package com.example.matthewdarke.advancedviews;

/**
 * Created by matthewdarke on 10/16/14.
 */
public class Gifts {






    public static Gifts newInstance(String _name,
                                    String _description, int _order) {
        Gifts gif = new Gifts();
        gif.setName(_name);
        gif.setDescription(_description);
        gif.setOrderNumb(_order);
        return gif;
    }

    // Member variables
    private int gOrderNumb;
    private String gName;
    private String gDescription;




    // Class constructor
    public Gifts() {
        gOrderNumb = 0;
        gName = "";
        gDescription = "";
    }

    public Gifts(String _name, String _description, int _order) {
        gOrderNumb = _order;
        gName = _name;
        gDescription = _description;
    }


    // Getter and setter methods.
    public int getOrderNumb() {
        return gOrderNumb;
    }

    public void setOrderNumb(int _order) {
        gOrderNumb = _order;
    }

    public String getName() {
        return gName;
    }

    public void setName(String _name) {
        gName = _name;
    }

    public String getDescription() {
        return gDescription;
    }

    public void setDescription(String _description) {
        gDescription = _description;
    }

    @Override
    public String toString() {
        return gName + " - " + gDescription + " - " + gOrderNumb;
    }
}




