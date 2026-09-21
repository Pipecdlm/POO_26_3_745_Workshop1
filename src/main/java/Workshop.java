public class Workshop
{
    // ---------- Números ----------

    public static int sumarDosNumeros(int a, int b)
    {
        return a + b;
    }

    public static int mayorDeTresNumeros(int a, int b, int c)
    {
        int mayor = a;
        if (b > mayor) mayor = b;
        if (c > mayor) mayor = c;
        return mayor;
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
        for (int i = 5; i * i <= numero; i += 6)
        {
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

    // ---------- Arreglos ----------

    public static int sumaElementos(int[] arreglo)
    {
        int suma = 0;
        for (int i = 0; i < arreglo.length; i++) suma += arreglo[i];
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
        for (int i = 1; i < arreglo.length; i++)
        {
            if (arreglo[i] > mayor) mayor = arreglo[i];
        }
        return mayor;
    }

    public static int encontrarElementoMenor(int[] arreglo)
    {
        int menor = arreglo[0];
        for (int i = 1; i < arreglo.length; i++)
        {
            if (arreglo[i] < menor) menor = arreglo[i];
        }
        return menor;
    }

    public static boolean buscarElemento(int[] arreglo, int elemento)
    {
        for (int i = 0; i < arreglo.length; i++)
        {
            if (arreglo[i] == elemento) return true;
        }
        return false;
    }

    public static int[] invertirArreglo(int[] arreglo)
    {
        int[] invertido = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++)
        {
            invertido[i] = arreglo[arreglo.length - 1 - i];
        }
        return invertido;
    }

    // Ordenamiento burbuja sobre una copia
    public static int[] ordenarArreglo(int[] arreglo)
    {
        int[] copia = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) copia[i] = arreglo[i];

        for (int i = 0; i < copia.length - 1; i++)
        {
            for (int j = 0; j < copia.length - 1 - i; j++)
            {
                if (copia[j] > copia[j + 1])
                {
                    int temp = copia[j];
                    copia[j] = copia[j + 1];
                    copia[j + 1] = temp;
                }
            }
        }
        return copia;
    }

    public static int[] eliminarDuplicados(int[] arreglo)
    {
        // Primero se cuentan los elementos únicos
        int unicos = 0;
        for (int i = 0; i < arreglo.length; i++)
        {
            boolean repetido = false;
            for (int j = 0; j < i; j++)
            {
                if (arreglo[j] == arreglo[i])
                {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) unicos++;
        }

        // Luego se llenan en un arreglo del tamaño exacto (mantiene el orden original)
        int[] resultado = new int[unicos];
        int pos = 0;
        for (int i = 0; i < arreglo.length; i++)
        {
            boolean repetido = false;
            for (int j = 0; j < i; j++)
            {
                if (arreglo[j] == arreglo[i])
                {
                    repetido = true;
                    break;
                }
            }
            if (!repetido)
            {
                resultado[pos] = arreglo[i];
                pos++;
            }
        }
        return resultado;
    }

    public static int[] combinarArreglos(int[] arreglo1, int[] arreglo2)
    {
        int[] combinado = new int[arreglo1.length + arreglo2.length];
        for (int i = 0; i < arreglo1.length; i++)
        {
            combinado[i] = arreglo1[i];
        }
        for (int i = 0; i < arreglo2.length; i++)
        {
            combinado[arreglo1.length + i] = arreglo2[i];
        }
        return combinado;
    }

    public static int[] rotarArreglo(int[] arreglo, int posiciones)
    {
        int len = arreglo.length;
        int[] rotado = new int[len];
        if (len == 0) return rotado;

        posiciones = ((posiciones % len) + len) % len; // también funciona con negativos
        for (int i = 0; i < len; i++)
        {
            rotado[i] = arreglo[((i - posiciones) % len + len) % len];
        }
        return rotado;
    }

    // Se usa el nombre completo java.util.List para no requerir una sentencia "import"
    public static double promedioLista(java.util.List<Integer> lista)
    {
        if (lista == null || lista.isEmpty()) return 0;
        int suma = 0;
        for (int i = 0; i < lista.size(); i++)
        {
            suma += lista.get(i);
        }
        return (double) suma / lista.size();
    }

    // ---------- Cadenas ----------

    // Auxiliares para no depender de toLowerCase / toUpperCase
    private static char aMinuscula(char c)
    {
        if (c >= 'A' && c <= 'Z') return (char) (c + 32);
        return c;
    }

    private static char aMayuscula(char c)
    {
        if (c >= 'a' && c <= 'z') return (char) (c - 32);
        return c;
    }

    private static boolean sonIguales(String a, String b)
    {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++)
        {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static int contarCaracteres(String cadena)
    {
        if (cadena == null) return 0;
        return cadena.length();
    }

    public static String invertirCadena(String cadena)
    {
        char[] letras = new char[cadena.length()];
        for (int i = 0; i < cadena.length(); i++)
        {
            letras[i] = cadena.charAt(cadena.length() - 1 - i);
        }
        return new String(letras);
    }

    public static boolean esPalindromo(String cadena)
    {
        if (cadena == null) return false;
        int i = 0, j = cadena.length() - 1;
        while (i < j)
        {
            if (aMinuscula(cadena.charAt(i)) != aMinuscula(cadena.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    public static int contarPalabras(String cadena)
    {
        if (cadena == null) return 0;
        int palabras = 0;
        boolean dentroDePalabra = false;
        for (int i = 0; i < cadena.length(); i++)
        {
            char c = cadena.charAt(i);
            boolean esEspacio = (c == ' ' || c == '\t' || c == '\n' || c == '\r');
            if (!esEspacio && !dentroDePalabra)
            {
                palabras++;
                dentroDePalabra = true;
            }
            else if (esEspacio)
            {
                dentroDePalabra = false;
            }
        }
        return palabras;
    }

    public static String convertirAMayusculas(String cadena)
    {
        char[] letras = new char[cadena.length()];
        for (int i = 0; i < cadena.length(); i++)
        {
            letras[i] = aMayuscula(cadena.charAt(i));
        }
        return new String(letras);
    }

    public static String convertirAMinusculas(String cadena)
    {
        char[] letras = new char[cadena.length()];
        for (int i = 0; i < cadena.length(); i++)
        {
            letras[i] = aMinuscula(cadena.charAt(i));
        }
        return new String(letras);
    }

    public static int buscarSubcadena(String cadena, String subcadena)
    {
        if (subcadena.length() == 0) return 0;
        for (int i = 0; i <= cadena.length() - subcadena.length(); i++)
        {
            boolean coincide = true;
            for (int j = 0; j < subcadena.length(); j++)
            {
                if (cadena.charAt(i + j) != subcadena.charAt(j))
                {
                    coincide = false;
                    break;
                }
            }
            if (coincide) return i;
        }
        return -1;
    }

    public static String reemplazarSubcadena(String cadena, String vieja, String nueva)
    {
        if (vieja.length() == 0) return cadena;

        String resultado = "";
        int i = 0;
        while (i < cadena.length())
        {
            boolean coincide = false;
            if (i + vieja.length() <= cadena.length())
            {
                coincide = true;
                for (int j = 0; j < vieja.length(); j++)
                {
                    if (cadena.charAt(i + j) != vieja.charAt(j))
                    {
                        coincide = false;
                        break;
                    }
                }
            }

            if (coincide)
            {
                resultado = resultado + nueva;
                i = i + vieja.length();
            }
            else
            {
                resultado = resultado + cadena.charAt(i);
                i++;
            }
        }
        return resultado;
    }

    private static boolean esCaracterDeNombre(char c)
    {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '_' || c == '-';
    }

    // Formato: usuario@dominio.ext  (mismo criterio que la expresión regular original)
    public static boolean validarCorreoElectronico(String correo)
    {
        if (correo == null) return false;

        int arroba = -1;
        for (int i = 0; i < correo.length(); i++)
        {
            if (correo.charAt(i) == '@')
            {
                if (arroba != -1) return false; // más de una arroba
                arroba = i;
            }
        }
        if (arroba <= 0) return false; // sin arroba o sin usuario

        // Usuario: letras, números, _, - y .
        for (int i = 0; i < arroba; i++)
        {
            char c = correo.charAt(i);
            if (!esCaracterDeNombre(c) && c != '.') return false;
        }

        // Dominio: una sola parte antes del punto y una extensión de 2+ letras
        int punto = -1;
        for (int i = arroba + 1; i < correo.length(); i++)
        {
            if (correo.charAt(i) == '.')
            {
                if (punto != -1) return false; // más de un punto
                punto = i;
            }
        }
        if (punto == -1 || punto == arroba + 1) return false;

        for (int i = arroba + 1; i < punto; i++)
        {
            if (!esCaracterDeNombre(correo.charAt(i))) return false;
        }

        if (correo.length() - punto - 1 < 2) return false;
        for (int i = punto + 1; i < correo.length(); i++)
        {
            char c = correo.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) return false;
        }
        return true;
    }

    // ---------- Conversiones ----------

    public static String convertirABinario(int numero)
    {
        if (numero == 0) return "0";

        boolean esNegativo = numero < 0;
        int valor = esNegativo ? -numero : numero;

        String resultado = "";
        while (valor > 0)
        {
            int bit = valor % 2;
            resultado = bit + resultado;
            valor = valor / 2;
        }

        return esNegativo ? "-" + resultado : resultado;
    }

    public static String convertirAHexadecimal(int numero)
    {
        if (numero == 0) return "0";

        boolean esNegativo = numero < 0;
        int valor = esNegativo ? -numero : numero;

        String digitos = "0123456789ABCDEF";
        String resultado = "";
        while (valor > 0)
        {
            int digito = valor % 16;
            resultado = digitos.charAt(digito) + resultado;
            valor = valor / 16;
        }

        return esNegativo ? "-" + resultado : resultado;
    }

    // ---------- Piedra, papel, tijera, lagarto, Spock ----------

    // Orden circular: cada opción vence a las dos anteriores
    // 0 piedra, 1 spock, 2 papel, 3 lagarto, 4 tijera
    private static int indiceOpcion(String eleccion)
    {
        if (eleccion == null) return -1;
        String e = convertirAMinusculas(eleccion);
        if (sonIguales(e, "piedra")) return 0;
        if (sonIguales(e, "spock")) return 1;
        if (sonIguales(e, "papel")) return 2;
        if (sonIguales(e, "lagarto")) return 3;
        if (sonIguales(e, "tijera")) return 4;
        return -1;
    }

    // true si a vence a b
    private static boolean vence(int a, int b)
    {
        int diferencia = (a - b + 5) % 5;
        return diferencia == 1 || diferencia == 2;
    }

    public static String jugarPiedraPapelTijeraLagartoSpock(String eleccion)
    {
        int jugador = indiceOpcion(eleccion);
        if (jugador == -1) return "Elección inválida";

        // Número "aleatorio" del 0 al 4 usando el reloj del sistema
        int pc = (int) (System.nanoTime() % 5);
        if (pc < 0) pc = -pc;

        if (jugador == pc)
        {
            return "Empate";
        }
        if (vence(jugador, pc))
        {
            return "Ganaste";
        }
        return "Perdiste";
    }

    public static String pptls2(String[] game)
    {
        if (game == null || game.length != 2) return "Entrada inválida";

        int p1 = indiceOpcion(game[0]);
        int p2 = indiceOpcion(game[1]);
        if (p1 == -1 || p2 == -1) return "Entrada inválida";

        if (p1 == p2) return "Empate";
        if (vence(p1, p2)) return "Jugador 1 gana";
        return "Jugador 2 gana";
    }

    // ---------- Geometría y zodiaco ----------

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