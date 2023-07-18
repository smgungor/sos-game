# sos-game

<details>
  <summary>Project Requirements</summary>

"Kare şeklinde nxn kutulardan oluşan bir panelde iki kişi tarafından oynanan bir oyundur. Oyun sırasında her bir kutuya s yada o harflerinden biri yerleştirilir. Oyunun başında hangi oyuncunun hangi harfi yerleştireceği ve kimin başlayacağına karar verilir. Amaç bir harf koyduğumuzda yatayda, dikeyde yada çaprazda SOS kelimesini oluşturmaktır. SOS kelimesini oluşturan oyuncu 1 puan alır ve tekrar harf ekleme hakkı kazanır. Panel üzerinde hiç boş kutu kalmayana kadar oyun oynanır, sonunda en çok puanı alan oyunu kazanır."

### Rules

- Panel büyüklüğü oyunun en başında konsoldan girdi olarak alınır. Minimum 3x3 maksimum 7x7 büyüklüğünde olmalıdır.
- Oyun bir kullanıcı tarafından bilgisayara karşı oynanır.
- Hangi oyuncunun hangi harfi alacağına ve kimin başlayacağına random karar verilir.
- Oyuncu hangi kutuya harfini girmek istediğini satır ve sütun numarasını konsoldan girerek belli eder.
- Bilgisayar hangi kutuya harf yazacağına panel üzerindeki boş kutulardan birini random seçerek karar verir.
- Panele her karakter girişinde panelin güncel hali satır ve sütun numaraları ile birlikte ve oyuncuların puan durumu ekranda gösterilir.
- Dolu kutulara harf yazılmasına izin verilmez." 

</details>


### Açıklama

- Oyun alanı için girdi alınarak oyun alanı oluşturulmaktadır. Oyun alanı minimum 3x3 maksimum 7x7 büyüklüğünde oluşturulabilmektedir. Bu alanlar dışında olan girdi işlemlerinde ise uyarı mesajları yazdırılmaktadır.

![Ekran görüntüsü 2022-07-24 22544 (1)](https://user-images.githubusercontent.com/72219337/180663713-584832e6-76c7-43fd-95b8-7e86932c8ae2.jpg)

- Oyuna başlayan oyuncu ve oyuncunun kullanacağı harf rastgele olarak belirlenmektedir. Computer için satır ve sütun değerleri boş olan alanlar arasından ratgele seçilmektedir. Player için satır ve sütun değerleri konsol üzerinden girdi olarak istenmektedir. Oyuncunun girmiş olduğu satır ve sütun değerleri için boşluk kontrolü yapılır. Boş olaması durumunda hamle gerçekleştirilir. Oyuncunun kullanacağı harf restgele olarak atanmaktadır.

![Ekran görüntüsü 2022-07-24 22544 (2)](https://user-images.githubusercontent.com/72219337/180664002-6cfc29fc-f64a-4772-9d87-ee4d2902ba5f.jpg)

![Ekran görüntüsü 2022-07-24 23084](https://user-images.githubusercontent.com/72219337/180664080-b16014fb-ae15-419f-9454-5ded58c8a72f.jpg)

- Her oluşturulan SOS kelimesi için oyun genelinde 1 puan kazanılmaktadır. SOS kelimesini oluşturabilen karakter bir oyun hakkına daha sahip olmaktadır. Bir hamlede birden fazla SOS kelimesi oluşturularak birden fazla puan kazaılabilmektedir.

![Ekran görüntüsü 2022-07-24 22544 (3)](https://user-images.githubusercontent.com/72219337/180664244-abc221cc-5ef5-44a6-8ab3-b699c9b8a65a.jpg)

- Oyun sonunda en fazla puana sahip olan karakter kazanmaktadır.

![Ekran görüntüsü 2022-07-24 231945](https://user-images.githubusercontent.com/72219337/180664396-e9a4d8f7-0983-4bb2-a727-3c77204e8687.jpg)
