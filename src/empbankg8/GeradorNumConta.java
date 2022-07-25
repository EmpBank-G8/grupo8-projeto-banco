package empbankg8;

public class GeradorNumConta {
private static int ID = 20000;
	
	public static int geraNumConta() {
		ID = ID + 1;
		return (ID);
	}
}