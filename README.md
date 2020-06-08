# Program UAS Pemrograman Java
Deskripsi Program:

Adalah aplikasi untuk melakukan pendataan seputar akademik kampus, mulai dari Mahasiswa, Staff Perkuliahan, 
Disertai juga dengan jurusan, Ruangan dan Matakuliah.

## Installation
git clone (url)

* Install DB Yang disediakan di folder
* Open Project di netbeans
* Clean and build di netbeans.
* Jika success Run satu folder.
* Buka localhost:8085/

### Untuk login
* User name: 51170018
* Password: 12345

## Error List
### Jika error cek:
1. projectUAS > othersource > src/main/resource > defaultpackage > application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/uas_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
server.port = 8085

```
### Perbaikan nya
* Ganti uas_db dengan nama database nya..
* ganti username dan password
* ganti server port jika ada tabrakan

2. lakukan resolve jika belum, atau clean build lagi setelah nomor 1
3. pastikan tidak ada aplikasi web dengan port sama yang berjalan
4. pastikan menginstall DB dari sql yang diberikan



