import java.util.Arrays;

public class Basket {

    private Item[] basketContents = new Item[10];

    public void addItem(Item newItem) {
        for (int i = 0, j = this.basketContents.length; i < j; i++) {
            if (this.basketContents[i] == null) {
                this.basketContents[i] = newItem;
                return;
            }
        }
    }

    public Item[] getBasketContents() {
        return this.basketContents;
    }

    public boolean removeItem(Item itemToRemove) {
        for (int i = 0, j = this.basketContents.length; i < j; i++) {
            try {
                // add a null check to prevent the NullPointerException from being thrown, then refactored to use a try catch block to catch the null exception and return false.
                if (/*this.basketContents[i] != null &&*/ this.basketContents[i].equals(itemToRemove)) {
                    this.basketContents[i] = null;
                    return true;
                }
            } catch (NullPointerException nullPointerException) {
                return false;
            }
        }
        return false;
    }
}
