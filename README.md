## Tentang Program

Aplikasi Movie disusun atas tiga folder utama, yaitu:

| Folder              | Peran                                                                                                                                                                  |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| data/               | folder ini berisi provider dan implementasi dari repository                                                                                                            |
| data/providers      | folder ini berisi provider yang berfungsi untuk menyediakan data yang akan digunakan di repository. dalam kasus ini, data tersebut berasal dari file lokal (json file) |
| data/repositories   | folder ini berisi repository-repository. repository berfungsi sebagai input output dari data source atau sebagai penghubung data source dengan business logic          |
| domain/             | folder ini berisi models/entity, use cases, dan repository interfaces                                                                                                  |
| domain/models       | folder ini berisi models atau entitas yang digunakan dalam program                                                                                                     |
| domain/repositories | folder ini berisi interface-interface dari repository atau kontrak dari repository                                                                                     |
| domain/usecases     | folder ini berisi usecase atau logika bisnis dari program                                                                                                              |
| presentation/       | folder ini berisi UI atau tampilan dari program                                                                                                                        |
