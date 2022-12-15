package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.Produto;
import modelo.Venda;

public class VendaPersis extends Persistencia {

	public void save(ArrayList<Venda> v) {
		
		try (FileWriter outFile = new FileWriter("Trans.txt")) {
			BufferedWriter outStream = new BufferedWriter(outFile);
	
			outStream.write(Integer.toString(v.size()));
			outStream.write("\n");
			
			for (int k = 0; k < v.size(); k++) {
				outStream.write(Integer.toString(v.get(k).getId())); 
				outStream.write("\n");
				outStream.write(Integer.toString(v.get(k).getProds().size())); 
				outStream.write("\n");
				outStream.write(Integer.toString(v.get(k).getCli().getId())); 
				outStream.write("\n");
				outStream.write(Integer.toString(v.get(k).getTrDay())); 
				outStream.write("\n");
				outStream.write(Integer.toString(v.get(k).getTrMon()));
				outStream.write("\n");
				
				for(int i = 0; i < v.get(k).getProds().size(); i++) {
					outStream.write(Integer.toString(v.get(k).getProds().get(i).getId()));
					outStream.write("\n");
				}
				
			}
	            
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Venda> read(ArrayList<Cliente> cli, ArrayList<Produto> prods) {
		ArrayList<Venda> v = new ArrayList<Venda>();
		
		try (FileReader inFile = new FileReader("Trans.txt")) {
			BufferedReader inStream = new BufferedReader(inFile);
            int id, numProd, idP, idC, trDay, trMon, a;
			
            try {
            	a = Integer.parseInt(inStream.readLine());
            	
            	for(int i = 0; i < a; i++){
                	id = Integer.parseInt(inStream.readLine());
                	numProd = Integer.parseInt(inStream.readLine());
                	idC = Integer.parseInt(inStream.readLine());
                	trDay = Integer.parseInt(inStream.readLine());
                    trMon = Integer.parseInt(inStream.readLine());
                    
					for(int j = 0; j < numProd; j++) {
					    
						if(j == 0) {
							idP = Integer.parseInt(inStream.readLine());
							v.add(new Venda(id, prods.get(idP), cli.get(idC), trDay, trMon));
						} else {
							idP = Integer.parseInt(inStream.readLine());
							v.get((v.size() - 1)).addProd(prods.get(idP));
						}
						
					}
                     
                }
            	
            	inFile.close();
            	
            } catch(Exception e) {
            	return v;
            }

            inFile.close();
        } catch (IOException e) {
        }
		
		return v;
	}
	
}
