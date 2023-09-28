package ClientServer;


import java.rmi.*;
import java.rmi.registry.*;

public class MyServerRmi {

    public static void main(String args[]) {
        try {
            Registry regs = LocateRegistry.createRegistry(Integer.parseInt(args[0]));
            Filtrer skeleton = new FiltreRemote();
            Naming.rebind("rmi://localhost:"+args[0]+"/"+args[1], skeleton);
            System.out.println("Server is ready ...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
