import java.util.ArrayList;
import java.util.List;

public class CamelCase {

	private static final List<String> lista = new ArrayList<String>();
	private static String aux;
	private static String s[];
	
	public static List<String> converterCamelCase(String Original) {
		lista.add(Original);
		if (lista.get(0).matches("^[0-9].*")) {
			throw new ComecaComNumeroException ("String iniciada por numero.");
		}
		if (lista.get(0).matches(".*[!@#$%&*].*")) {
			throw new TemEspecialException ("String com caracter especial.");
		}
		separaString();
		trataString();
		return CamelCase.lista;
	}
	
	public static void limpaLista() {
		lista.clear();
	}
	
	public static void trataString() {
		if (s.length == 1)
			if(s[0].matches("[A-Z]{2,}")) {
				lista.set(0, lista.get(0).toUpperCase());
			} else {
				lista.set(0, lista.get(0).toLowerCase());
			}
		if (s.length  > 1) {
			lista.remove(0);
				for (int i = 0; i < s.length; i++) {
					lista.add(i, s[i]);
					if(s[i].matches("[A-Z]{2,}")) {
						lista.set(i, lista.get(i).toUpperCase());
					} else {
						lista.set(i, lista.get(i).toLowerCase());
					}
				}	
			}
	}
	
	public static void separaString(){
		aux = lista.get(0);
		s = aux.split("(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!(^|[^A-Z]))(?=[0-9])|(?<!(^|[^0-9]))"
				+ "(?=[A-Za-z])|(?<!^)(?=[A-Z][a-z])");
	}
}