1) ## 1. **Array-Based Stack**

- **Estructura interna:**  
    Usa un **array fijo** para guardar elementos y una variable `topIndex` que señala la posición del último elemento insertado.
    
    - Cuando el stack está vacío: `topIndex = -1`.
        
    - Cada `push` incrementa `topIndex` y guarda el elemento.
        
    - Cada `pop` elimina el elemento en `topIndex` y lo decrementa.
        
- **Métodos principales:**
    
    `public boolean isEmpty() {     return (topIndex == -1); }  public boolean isFull() {     return (topIndex == elements.length - 1); }  public void push(T element) {     if (isFull())         throw new StackOverflowException("Push attempted on a full stack.");     else {         topIndex++;         elements[topIndex] = element;     } }  public void pop() {     if (isEmpty())         throw new StackUnderflowException("Pop attempted on empty stack.");     else {         elements[topIndex] = null;         topIndex--;     } }`
    
- **Ventajas:** simple, eficiente, acceso constante.
    
- **Desventajas:** tamaño fijo (si lo llenas → `StackOverflowException`).
- Lo que entendi:
-para implementar el stack debes crear una variable llamada topIndex == -1 en un metodo topIndex que devuelve un valor booleano para asegurarme que el Stack esta vacio? luego se crea otro metodo llamado isFull que tambien da de retorno un valor booleano para asegurarme de que no este full y se usa (topIndex == elements.length - 1); para asegurarme que minimo le cabe un elemento mas no? y luego se crean dos metodos que hacen el push y pop y tiran una excepcion en base si el Stack esta full o vacio y si no hat problemas se le suma 1 a la variable top index y hacemos elements[topIndex] = element (en el caso de que estemos metiendo el un elemento dentro de elementos en push) y elements [topIndex] = null; topIndex--; (esto en el caso de que estemos haceindo el pop, le sacamos 1 a top index (lo que no entiendo es por que null? no seria el element? por que estamos popeando lo que estaba dentro de el Stack no? y por que los metodos no reciben la variable topIndex asi: 
public void pop(boolean topIndex) {} ))