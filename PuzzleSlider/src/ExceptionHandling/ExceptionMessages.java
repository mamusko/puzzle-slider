package ExceptionHandling;

public class ExceptionMessages {

	public static String GameDimensions( int dims ) {
		return String.format( "New game can't be %dx%d", dims, dims);
	}
	
}
