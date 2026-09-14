import java.util.List;

public class Workshop

{
public static int sumarDosNumeros(int a, int b) 
{
return a + b;
}
public static int mayorDeTresNumeros(int a, int b, int c) 
{
return Math.max(a, Math.max(b, c));
}
public static int[] tablaMultiplicar(int numero, int limite)
{
int[] tabla = new int[limite];
for (int i = 1; i <= limite; i++)
{
tabla[i - 1] = numero * i;
}
return tabla;
}
public static long factorial(int n)
{
if (n < 0) throw new IllegalArgumentException("n debe ser >= 0");
long fact = 1;
for (int i = 2; i <= n; i++) fact *= i;
return fact;
}
public static boolean esPrimo(int numero) 
{
if (numero <= 1) return false;
if (numero <= 3) return true;
if (numero % 2 == 0 || numero % 3 == 0) return false;
for (int i = 5; i * i <= numero; i += 6) {
if (numero % i == 0 || numero % (i + 2) == 0) return false;
}
return true;
}
public static int[] serieFibonacci(int n)
{
if (n < 0) throw new IllegalArgumentException("n debe ser >= 0");
int[] fib = new int[n];
if (n > 0) fib[0] = 0;
if (n > 1) fib[1] = 1;
for (int i = 2; i < n; i++) 
{
fib[i] = fib[i - 1] + fib[i - 2];
}
return fib;
}
public static int sumaElementos(int[] arreglo)
{
int suma = 0;
for (int num : arreglo) suma += num;
return suma;
}
public static double promedioElementos(int[] arreglo)
{
if (arreglo.length == 0) return 0;
return (double) sumaElementos(arreglo) / arreglo.length;
}
public static int encontrarElementoMayor(int[] arreglo) 
{
int mayor = arreglo[0];
for (int num : arreglo) 
{
if (num > mayor) mayor = num;
}
return mayor;
}
public static int encontrarElementoMenor(int[] arreglo)
{
int menor = arreglo[0];
for (int num : arreglo) 
{
if (num < menor) menor = num;
}
return menor;
}

public static boolean buscarElemento(int[] arreglo, int elemento) 
{
for (int num : arreglo) 
{
if (num == elemento) return true;
}
return false;
}

public static int[] invertirArreglo(int[] arreglo) 
{
int[] invertido = Arrays.copyOf(arreglo, arreglo.length);
for (int i = 0, j = arreglo.length - 1; i < j; i++, j--) 
{
int temp = invertido[i];
invertido[i] = invertido[j];
invertido[j] = temp;
}
return invertido;
}

public static int[] ordenarArreglo(int[] arreglo) 
{
int[] copia = Arrays.copyOf(arreglo, arreglo.length);
Arrays.sort(copia);
return copia;
}

public static int[] eliminarDuplicados(int[] arreglo) 
{
return Arrays.stream(arreglo).distinct().toArray();
}

public static int[] combinarArreglos(int[] arreglo1, int[] arreglo2) 
{
int[] combinado = new int[arreglo1.length + arreglo2.length];
System.arraycopy(arreglo1, 0, combinado, 0, arreglo1.length);
System.arraycopy(arreglo2, 0, combinado, arreglo1.length, arreglo2.length);
return combinado;
}

public static int[] rotarArreglo(int[] arreglo, int posiciones) 
{
int len = arreglo.length;
int[] rotado = new int[len];
posiciones = posiciones % len;
for (int i = 0; i < len; i++) {
rotado[i] = arreglo[(i + posiciones) % len];
}
return rotado;
}

public static int contarCaracteres(String cadena) 
{
if (cadena == null) return 0;
return cadena.length();
}

public static String invertirCadena(String cadena) 
{
return new StringBuilder(cadena).reverse().toString();
}

public static boolean esPalindromo(String cadena) 
{
if (cadena == null) return false;
String s = cadena.toLowerCase();
int i = 0, j = s.length() - 1;
while (i < j) {
if (s.charAt(i) != s.charAt(j)) return false;
i++;
j--;
}
return true;
}

public static int contarPalabras(String cadena) 
{
if (cadena == null || cadena.trim().isEmpty()) return 0;
return cadena.trim().split("\\s+").length;
}

public static String convertirAMayusculas(String cadena) 
{
return cadena.toUpperCase();
}

public static String convertirAMinusculas(String cadena) 
{
return cadena.toLowerCase();
}

public static String reemplazarSubcadena(String cadena, String vieja, String nueva) 
{
return cadena.replace(vieja, nueva);
}

public static int buscarSubcadena(String cadena, String subcadena) 
{
return cadena.indexOf(subcadena);
}

public static boolean validarCorreoElectronico(String correo) 
{
if (correo == null) return false;
return correo.matches("^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$");
}

public static double promedioLista(List<Integer> lista) 
{
if (lista == null || lista.isEmpty()) return 0;
return lista.stream().mapToInt(Integer::intValue).average().orElse(0);
}

public static String convertirABinario(int numero) 
{
return Integer.toBinaryString(numero);
}

public static String convertirAHexadecimal(int numero) 
{
return Integer.toHexString(numero).toUpperCase();
}

public static String jugarPiedraPapelTijeraLagartoSpock(String eleccion) 
{
String[] opciones = {"piedra", "papel", "tijera", "lagarto", "spock"};
String eleccionPc = opciones[new Random().nextInt(opciones.length)];

if (!Arrays.asList(opciones).contains(eleccion.toLowerCase())) 
{
return "Elección inválida";
}

if (eleccionPc.equals(eleccion.toLowerCase())) 
{
return "Empate: ambos eligieron " + eleccionPc;
}

// Reglas del juego
Map<String, List<String>> ganaA = new HashMap<>();
ganaA.put("piedra", List.of("tijera", "lagarto"));
ganaA.put("papel", List.of("piedra", "spock"));
ganaA.put("tijera", List.of("papel", "lagarto"));
ganaA.put("lagarto", List.of("spock", "papel"));
ganaA.put("spock", List.of("tijera", "piedra"));

if (ganaA.get(eleccion.toLowerCase()).contains(eleccionPc)) 
{
return "Ganaste: " + eleccion + " vence a " + eleccionPc;
} 
else 
{
return "Perdiste: " + eleccionPc + " vence a " + eleccion;
}

public static String pptls2(String[] game) 
{
if (game.length != 2) return "Entrada inválida";
String p1 = game[0].toLowerCase();
String p2 = game[1].toLowerCase();
if (p1.equals(p2)) return "Empate";

Map<String, List<String>> ganaA = new HashMap<>();
ganaA.put("piedra", List.of("tijera", "lagarto"));
ganaA.put("papel", List.of("piedra", "spock"));
ganaA.put("tijera", List.of("papel", "lagarto"));
ganaA.put("lagarto", List.of("spock", "papel"));
ganaA.put("spock", List.of("tijera", "piedra"));

if (!ganaA.containsKey(p1) || !ganaA.containsKey(p2)) return "Entrada inválida";

if (ganaA.get(p1).contains(p2)) 
{
return "Jugador 1 gana";
} 
else if (ganaA.get(p2).contains(p1))
{
return "Jugador 2 gana";
} 
else 
{
return "Empate";
}

public static double areaCirculo(double radio) 
{
return Math.PI * radio * radio;
}

public static String zoodiac(int day, int month) 
{
String signo = "";
if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) signo = "Acuario";
else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) signo = "Piscis";
else if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) signo = "Aries";
else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) signo = "Tauro";
else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) signo = "Géminis";
else if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) signo = "Cáncer";
else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) signo = "Leo";
else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) signo = "Virgo";
else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) signo = "Libra";
else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) signo = "Escorpio";
else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) signo = "Sagitario";
else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) signo = "Capricornio";
return signo;
}
}


