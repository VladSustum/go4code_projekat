CREATE SCHEMA `restoran` ;

INSERT INTO `restoran`.`category` (`id`, `name`) VALUES ('1', 'pizza');
INSERT INTO `restoran`.`category` (`id`, `name`) VALUES ('2', 'dessert');
INSERT INTO `restoran`.`category` (`id`, `name`) VALUES ('3', 'pasta');
INSERT INTO `restoran`.`category` (`id`, `name`) VALUES ('4', 'wine');
INSERT INTO `restoran`.`category` (`id`, `name`) VALUES ('5', 'coffe');


INSERT INTO `restoran`.`menu` (`id`, `name`, `price`, `category_id`) VALUES ('1', 'pizza romana', '6.0', '1');
INSERT INTO `restoran`.`menu` (`id`, `name`, `price`, `category_id`) VALUES ('2', 'panna cotta', '6.5', '2');
INSERT INTO `restoran`.`menu` (`id`, `name`, `price`, `category_id`) VALUES ('3', 'pizza viennese', '7.0', '1');
INSERT INTO `restoran`.`menu` (`id`, `name`, `price`, `category_id`) VALUES ('4', 'cannelloni al forno', '2.0', '3');
INSERT INTO `restoran`.`menu` (`id`, `name`, `price`, `category_id`) VALUES ('5', 'chianti conte(0.175)', '3.0', '2');
INSERT INTO `restoran`.`menu` (`id`, `name`, `price`, `category_id`) VALUES ('6', 'chianti conte(0.75)', '10.0', '4');
INSERT INTO `restoran`.`menu` (`id`, `name`, `price`, `category_id`) VALUES ('7', 'pizza capricciosa', '3.5', '4');
INSERT INTO `restoran`.`menu` (`id`, `name`, `price`, `category_id`) VALUES ('8', 'pizza quattro stagioni', '3.0', '1');
INSERT INTO `restoran`.`menu` (`id`, `name`, `price`, `category_id`) VALUES ('9', 'cappuccino', '1.0', '5');
