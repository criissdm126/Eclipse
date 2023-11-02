package su;

public class Su {
	
		  public static long findNextSquare(long sq) {
			  String cuadrado2= String.valueOf(sq);
			  double cuadrado1= Double.parseDouble(cuadrado2);
		      double cuadrado =Math.sqrt(cuadrado1);
		    
		    
		    if (cuadrado% 1 == 0){
		      double sigcuadrado = (cuadrado+1);
		      sigcuadrado = sigcuadrado*sigcuadrado;
		      String sigcuadrado1=String.valueOf(sigcuadrado);
		      Long sigcuadrado2=Long.parseLong(sigcuadrado1);
		      return sigcuadrado2;
		    }else {
		      return -1;
		    }
		  }
		  
		  public static void main(String[] args) {
		
		System.out.println(findNextSquare(144));
			  
			}
		
	}


