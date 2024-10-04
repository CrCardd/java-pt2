public class Main {

    public static void main(String[] args){
        Conjunto conj = new Conjunto();
        Conjunto conj2 = new Conjunto();
        
        
        Conjunto conj3 = new Conjunto();
        
        conj3.Add("laranja");
        conj3.Add("limao");
        conj3.Add("limao");
        conj3.Add("maca");


        Conjunto conj4 = new Conjunto();
        
        conj4.Add("maca");
        conj4.Add("limao");
        conj4.Add("laranja");
        conj4.Add("limao");
        

        conj.Add(conj3);
        conj2.Add(conj4);

        System.err.println(conj.Intersect(conj2));

    }
    
}
