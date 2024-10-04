import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Conjunto{

    private HashSet<Object> data = new HashSet<>();

    public boolean Contains(Object search){
        return this.data.contains(search);
    };



    public HashSet<Object> GetData(){
        return this.data;
    }



    public void Add(Object value){
        this.data.add(value);
    }


    public Conjunto Intersect(Conjunto other){
        Conjunto intersect = new Conjunto();
        Iterator<Object> iterator = this.data.iterator();

        while(iterator.hasNext()){
            Object value = iterator.next();
            if (other.GetData().contains(value) && !intersect.Contains(value) ) 
                intersect.Add(value);
            
        }
        return intersect;
    }

    //TENAR DEPOIS
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.data.toString();
    }

}