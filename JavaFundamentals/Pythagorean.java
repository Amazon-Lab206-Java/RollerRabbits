import java.lang.Math;

public class Pythagorean {
        public double calculateHypotenuse(int legA, int legB) {
            double aSquared = legA * legA;
            double bSquared = legB * legB;

            return Math.sqrt(aSquared + bSquared);
        // the hypotenuse is the side across the right angle. 
        // calculate the value of c given legA and legB
    }
}