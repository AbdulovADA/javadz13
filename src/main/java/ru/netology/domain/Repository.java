package ru.netology.domain;


public class Repository {
    private Product[] product = new Product[0];


    public Product[] findAll() {
        return product;
    }

    public void save(Product addProduct) {
        int length = product.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < product.length; i++) {
            tmp[i] = product[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = addProduct;

        product = tmp;
    }

    public Product findById(int id) {
        for (int i = 0; i < product.length; i++) {
            if (product[i].getId() == id) {
                return product[i];
            }
        }
        return null;
    }

    public void removeById(int id) {
        Product toIdent = findById(id);
        if (toIdent == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        } else {
            int length = product.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (int i = 0; i < product.length; i++) {
                if (product[i].getId() != id) {
                    tmp[index] = product[i];
                    index++;
                }
            }
            product = tmp;
        }

    }
}
