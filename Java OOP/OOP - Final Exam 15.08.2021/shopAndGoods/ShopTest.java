package shopAndGoods;


import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelves() {
        Shop shop = new Shop();
        shop.getShelves().put("Shelve1", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodWrongShell() throws OperationNotSupportedException {
        Shop shop = new Shop();
        shop.addGoods("S", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWrong() throws OperationNotSupportedException {
        Shop shop = new Shop();

        Goods goods = new Goods("Name", "test");

        shop.addGoods("TestShelf", goods);
        shop.addGoods("TestShelf", goods);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddWrongSecond() throws OperationNotSupportedException {
        Shop shop = new Shop();
        shop.addGoods("Shelves1", null);

    }

    @Test
    public void testAddMethodWorksProperly() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("Pesho", "test");
        shop.addGoods("Shelves1", goods);
        Assert.assertEquals(shop.getShelves().get("Shelves1"), goods);

        String expected = String.format("Goods: %s is placed successfully!", goods.getGoodsCode());

        Assert.assertEquals(expected,"Goods: test is placed successfully!");

    }

    @Test
    public void testMethodReturnProperMessage() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("Pesho", "test");
        shop.addGoods("Shelves1", goods);

        String expected = String.format("Goods: %s is placed successfully!", goods.getGoodsCode());

        Assert.assertEquals(expected,"Goods: test is placed successfully!");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCellDoesNotExist() {
        Shop shop = new Shop();
        shop.removeGoods("D3", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemDoesNotExist() {
        Shop shop = new Shop();

        Goods goods = new Goods("petar", "test");

        shop.removeGoods("Shelves1", goods);

    }

    @Test
    public void testRemoveItemWorksProperly() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("petar", "test");
        shop.addGoods("Shelves1", goods);

        shop.removeGoods("Shelves1", goods);

        Assert.assertNull(shop.getShelves().get("Shelves1"));
    }

    @Test
    public void testRemoveReturnProperMessage() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("petar", "test");
        shop.addGoods("Shelves1", goods);


        String expected = String.format("Goods: %s is removed successfully!", goods.getGoodsCode());
        String actual = shop.removeGoods("Shelves1", goods);

        Assert.assertEquals(expected,actual);

    }
}
