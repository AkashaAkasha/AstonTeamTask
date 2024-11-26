package objects;

import java.io.Serializable;
import java.util.Objects;

public final class Animal implements Comparable<Animal>, Serializable{
    private  String kind;
    private  String yearColor;
    private  boolean isHair;

    private Animal(AnimalBuilder builder) {
        super();
        this.kind = builder.kind;
        this.yearColor = builder.yearColor;
        this.isHair = builder.isHair;
    }
    public static AnimalBuilder builder(){
        return new AnimalBuilder();
    } 

    public static class AnimalBuilder{
        private  String kind;
        private String yearColor;
        private boolean isHair;

        public AnimalBuilder kind (String kind) {
            this.kind = kind;
            return this;
        }
     
        public AnimalBuilder yearColor(String yearColor) {
            this.yearColor = yearColor;
            return this;
        }
        
        public AnimalBuilder age(boolean isHair) {
            this.isHair = isHair;
            return this;
        }
    
        public Animal build(){
            return new Animal(this);  
        } 
    }

    @Override
    public int compareTo(Animal other) {

        int kindComp = String.CASE_INSENSITIVE_ORDER.compare(this.kind, other.kind);
        if (kindComp != 0) {
            return kindComp;
        }
        int colorComp = String.CASE_INSENSITIVE_ORDER.compare(this.yearColor, other.yearColor);
        if (colorComp != 0) {
            return colorComp;
        }
        return (this.isHair && other.isHair)? 0: -1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind, color, isHair);
    }

    @Override
    public String toString() {
        return "Animal {" +
                " kind " + kind +
                ", yearColor " + yearColor +
                ", isHair " + isHair +
                "}";
    }
}
