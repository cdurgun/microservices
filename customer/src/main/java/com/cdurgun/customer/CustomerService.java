package com.cdurgun.customer;

import com.cdurgun.amqp.RabbitMQMessageProducer;
import com.cdurgun.clients.fraud.FraudCheckResponse;
import com.cdurgun.clients.fraud.FraudClient;
import com.cdurgun.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);

//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId());

        FraudCheckResponse fraudCheckResponse =
                fraudClient.isFrauster(customer.getId());

        if (fraudCheckResponse.isFrauster()) {
            throw new IllegalStateException("fraudster");
        }

        //send notification
        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi, %s, welcome to Amigoscode...", customer.getFirstName())
        );

        //notificationClient.sendNotification(notificationRequest);
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
                );

    }
}
