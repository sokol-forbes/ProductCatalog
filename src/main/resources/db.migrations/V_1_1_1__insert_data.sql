insert into product_category (id, name)
values (1, 'Еда'),
       (2, 'Вкусности'),
       (3, 'Вода');

insert into product (id, name, description, price, remark_general, remark_special, product_category_id)
values (1, 'Селедка', 'Селедка соленая', 222.23, 'Акция', 'Пересоленная', 1),
       (2, 'Тушенка', 'Селедка соленая', 124.23, 'Акция', 'Пересоленная', 1),
       (3, 'Сгущенка', 'Селедка соленая', 422.23, 'Акция', 'Пересоленная', 2)