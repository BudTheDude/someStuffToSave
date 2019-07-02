package mitaColocviu;

import java.util.Comparator;

public class Student  {
	String nume=new String();
	int id;
	double media;

	Student() {
		
	}

	Student(String nume, int id, double media) {
		this.nume = nume;
		this.id = id;
		this.media = media;
	}

	@Override
	public String toString() {

		return " Nume: " + nume + " Id: " + id + " Media: " + media;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	
	//Compare by name
	public static Comparator<Student> CompareByName = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			return s1.getNume().compareTo(s2.getNume());
			
		}
	};
	
	//Compare by ID
	public static Comparator<Student> CompareByID = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			return s1.getId()-s2.getId();
			
		}
	};
	
	//Compare by Medie
		public static Comparator<Student> CompareByMedie = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				if(s1.getMedia()<s2.getMedia()) {
					return -1;
				}else {
					return 1;
				}
				
			}
		};



}
