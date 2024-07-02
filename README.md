# Microservisler
Bu github repository deki kodlar ilişikteki eğitime göre düzenlenmiş ve üzerinde değişiklikler yapılmıştır:
https://www.amigoscode.com/courses/microservices

![Screenshot 2021-11-30 at 12 32 51](https://user-images.githubusercontent.com/40702606/144061535-7a42e85b-59d6-4f7f-9c35-18a48b49e6de.png)

- ### Mikroservis Mimarisi Nedir?
Her biri kendi başına bir proje olan, tek bir görevi olan projelerden oluşan mimariye mikroservis mimarisi denir.

- ### Mikroservislerin Avantajları
  - Bileşenler bağımsız oldukları için birbirlerinden bağımsız olarak güncellenebilir ve deploy edilebilir. Bu scalability'i
  iyileştirir.
  - Uygulamada hata olduğunda sadece ilgili bileşeni etkiler, uygulamanın tümüne bir etkisi olmaz.
  - Uygulamaya yeni özellikler eklemek çok daha kolaydır.
  - Bileşenler ana uygulamanın daha küçük parçaları olduğu için kodları anlamak ve yönetmek daha kolaydır.
  - Her bileşen bağımsız olarak ölçeklenebilir. Bu nedenle maliyet ve zaman açısından daha verimlidir.
  - Mikroservis mimarisi kullanan projeler teknoloji seçimi konusunda daha esnektir. Geliştiriciler her servis için farklı
  bir teknoloji kullabilir.
  - Agile (Çevik) uygulamalardır. Yapılan geliştirmeler ve değişiklikler çok daha az hata ile uygulanabilir.

- ### Mikroservislerin Dezavantajları
  - Daha karmaşık bir yapıya sahiptirler. Dağıtık bir yapıya sahip olduklarından tüm modüller ve veri tabanları arasındaki 
  bağlantıları seçmek ve kurmak gerekir.  
  - Her bir servisi bağımsız olarak deploy etmek gerekir.
  - Çok fazla bileşen olduğu için harici konfigürasyonlar, loglama, metrikler, performans izleme vb. işlerle ayrı ayrı
  ilgilenmek gereklidir.
  - Test etmek daha zordur

- ### Mikroservis Mimarisini Ne zaman Kullanmak Gerekir?
  - Uygulamamız komplekse ve scalable bir proje isteniyorsa
  - Uygulamada birçok modül ve kullanıcı bulunacaksa. Bu durumda yönetmek ve geliştirmek daha kolay olur.
  - Projede modüller arasında bağımlılıkların olmaması isteniyorsa