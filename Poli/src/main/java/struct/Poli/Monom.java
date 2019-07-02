package struct.Poli;


public class Monom implements Comparable<Monom> {
	private float coef;
	private int degree;
	
	public Monom(int degree, float coef) {
		this.coef=coef;
		this.degree=degree;
	}
	
	public float getCoef() {
		return coef;
	}
	
	public int getDegree() {
		return degree;
	}
	public void setCoef(float c) {
		coef=c;
	}
	public void setDegree(int d) {
		degree=d;
	}
	
	public int compareTo(Monom comparestu) {
			int compareDegree=((Monom)comparestu).getDegree();
			return compareDegree-this.getDegree();
    }

    @Override
    public String toString() {
        return null;
    }
	
}
