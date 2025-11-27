package com.example.myapplication

class DataRepository {

    fun getUsers(): List<User> = listOf(
        User(1, "Олександр Коваленко", "oleksandr@example.com", "", true),
        User(2, "Марія Шевченко", "maria@example.com", "", true),
        User(3, "Іван Петренко", "ivan@example.com", "", false),
        User(4, "Катерина Бондаренко", "kateryna@example.com", "", true),
        User(5, "Дмитро Мельник", "dmytro@example.com", "", false)
    )

    fun getProducts(): List<Product> = listOf(
        Product(1, "Ноутбук ASUS", 25000.0, "Електроніка", 4.5f, true),
        Product(2, "Смартфон Samsung", 15000.0, "Електроніка", 4.7f, true),
        Product(3, "Навушники Sony", 3500.0, "Аксесуари", 4.3f, false),
        Product(4, "Клавіатура Logitech", 1200.0, "Аксесуари", 4.6f, true),
        Product(5, "Монітор Dell", 8000.0, "Електроніка", 4.8f, true),
        Product(6, "Миша Razer", 900.0, "Аксесуари", 4.4f, true)
    )

    fun getCarouselProducts(): List<Product> = listOf(
        Product(101, "Планшет iPad", 20000.0, "Електроніка", 4.9f, true),
        Product(102, "Годинник Apple Watch", 12000.0, "Аксесуари", 4.7f, true),
        Product(103, "Камера GoPro", 8500.0, "Фото/Відео", 4.6f, true),
        Product(104, "Колонка JBL", 2500.0, "Аудіо", 4.5f, true)
    )

    fun getMixedList(): List<ListItem> = buildList {
        add(ListItem.HeaderItem("Користувачі"))
        getUsers().take(3).forEach { add(ListItem.UserItem(it)) }

        add(ListItem.HeaderItem("Рекомендовані товари"))
        add(ListItem.ProductCarouselItem(getCarouselProducts()))

        add(ListItem.HeaderItem("Всі товари"))
        getProducts().forEach { add(ListItem.ProductItem(it)) }

        add(ListItem.HeaderItem("Інші користувачі"))
        getUsers().drop(3).forEach { add(ListItem.UserItem(it)) }
    }
}