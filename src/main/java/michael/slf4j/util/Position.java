package michael.slf4j.util;

public class Position {
	public int x;
	public int y;
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(!(obj instanceof Position)){
			return false;
		}
		return hashCode() == obj.hashCode();
	}
	@Override
	public int hashCode() {
		return x * 100 + y;
	}
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
