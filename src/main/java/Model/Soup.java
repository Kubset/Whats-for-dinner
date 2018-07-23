package Model;

public class Soup {
    private String name;
    private int favourite;
    private int id;

    public Soup(String name, int favourite) {
        this.name = name;
        this.favourite = favourite;
    }

    public Soup(int id, String name, int favourite) {
        this.id = id;
        this.favourite = favourite;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }

    @Override
    public boolean equals(Object obj) {
        Soup s = (Soup) obj;
        if(this.name.equals(s.name) && this.favourite == s.favourite) {
            return true;
        } else {
            return false;
        }
    }
}
