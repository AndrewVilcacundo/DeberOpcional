import java.util.Stack;

public class Pila {
    private Stack<String> coleccion;
    private final int max=10;

    public Pila(){
        coleccion=new Stack<String>();
    }

    public void insertar(String dato) {
    if(coleccion.size() >= max){
        throw new IllegalStateException("No se puede insertar más elementos");
    }
        coleccion.push(dato);
    }

    public String extraer(){
        return coleccion.pop();
    }

    public String cima(){
        return coleccion.peek();
    }

    @Override
    public String toString() {
        StringBuilder lista=new StringBuilder();
        for(int i=coleccion.size()-1; i>=0; i--){
            lista.append(coleccion.get(i)+"\n");
        }
        return lista.toString();
    }
}
