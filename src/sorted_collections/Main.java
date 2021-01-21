package sorted_collections;

import java.util.Map;

public class Main {

    private static final StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 1.50, 100);
        stockList.addStock(temp);
        temp = new StockItem("cake", 2.10, 7);
        stockList.addStock(temp);
        temp = new StockItem("car", 2.50, 2);
        stockList.addStock(temp);
        temp = new StockItem("chair", 13.33, 23);
        stockList.addStock(temp);
        temp = new StockItem("cup", 1.55, 200);
        stockList.addStock(temp);
        temp = new StockItem("juice", 2.55, 12);
        stockList.addStock(temp);
        temp = new StockItem("phone", 12.33, 20);
        stockList.addStock(temp);
        temp = new StockItem("vase", 13.44, 20);
        stockList.addStock(temp);
        temp = new StockItem("towel", 17.99, 20);
        stockList.addStock(temp);
        temp = new StockItem("sheets", 23.55, 20);
        stockList.addStock(temp);
        temp = new StockItem("sheets", 10.00, 10);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket lenasBasket = new Basket("Lenas");
        sellItem(lenasBasket, "juice", 4);
        sellItem(lenasBasket, "cup", 3);
        sellItem(lenasBasket, "bread", 1);
        sellItem(lenasBasket, "cup", 3);
        sellItem(lenasBasket, "car", 2);
        sellItem(lenasBasket, "car", 1);
        if (sellItem(lenasBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock");
        }

        System.out.println(lenasBasket);

        Basket basket = new Basket("customer");
        sellItem(basket, "cup", 2);
        sellItem(basket, "juice", 1);
        sellItem(basket, "cup", 100);
        removeItem(lenasBasket, "cup", 9);
        removeItem(lenasBasket, "car", 1);
        System.out.println("Cars removed: " + removeItem(lenasBasket, "car", 1));

        System.out.println(lenasBasket);
        removeItem(lenasBasket, "bread", 1);
        removeItem(lenasBasket, "cup", 3);
        removeItem(lenasBasket, "juice", 4);
        removeItem(lenasBasket, "cup", 3);
        System.out.println(lenasBasket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(stockList);


        System.out.println("Price List:");
        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
            System.out.println("\t" + price.getKey() + ", " + price.getValue());
        }

        // throws UnsupportedOperationException -> unmodifiableMap
        temp = new StockItem("pen", 1.12);
        stockList.Items().put(temp.getName(), temp);

        // 2 ways of accessing
        StockItem car = stockList.Items().get("car");
        if (car != null) {
            stockList.Items().get("car").adjustStock(2000);
        }
        if (car != null) {
            stockList.get("car").adjustStock(-1000);
        }
        System.out.println(stockList);
    }

//    public static int sellItem(Basket basket, String item, int quantity) {
//        StockItem stockItem = stockList.get(item);
//        if (stockItem == null) {
//            System.out.println(String.format("We don't sell item %s", item));
//            return 0;
//        }
//        if (stockList.sellStock(item, quantity) != 0) {
//            basket.addToBasket(stockItem, quantity);
//            return quantity;
//        }
//        return 0;
//    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We do not sell item " + item);
            return 0;
        }
        if (stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We do not sell item " + item);
            return 0;
        }
        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.emptyBasket();
    }

//    public static int removeFromTheBasket(Basket basket, String item, int quantity) {
//        StockItem stockItem = stockList.get(item);
//        if (stockItem == null) {
//            System.out.println("We do not sell " + item);
//        }
//        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
//            return stockList.unreserveStock(item, quantity);
//        }
//        return 0;
//    }


}
