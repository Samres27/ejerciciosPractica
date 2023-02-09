/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.divideyvenceras;
import java.util.*;
import java.io.*;
/**
 *
 * @author SAMUEL
 */
public class ejerci2 {

	public static void main (String[] abc){
        //primeras 3 consultas 
        FastReader sc= new FastReader();
        LinkedList<Integer> nums= new LinkedList<>();
        nums.add(4);
        nums.add(8);
        nums.add(15);
        nums.add(16);
        nums.add(23);
        nums.add(42);
        int[] resp=new int[2];
        int[] respa2=new int[3];
        int[] respa1=new int[3];
        int c=1;
        for(int k=0;k<2;k++){
            while(c-k*3<=2){
             String r= "? "+(c)+" "+(c+1);
             System.out.println(r);
             System.out.flush();
             resp[c-k*3-1]=sc.nextInt();
             c++;
            }
            c++;
            
            if(k==0){respa1= encontarValores(resp,nums);}else{
                respa2= encontarValores(resp,nums);
            }
        }
        System.out.print("! ");
        for(int i=0;i<6;i++){
            String r;
            if(i>=3){
                r=respa2[i-3]+" ";
            }else{
                r=respa1[i]+" ";
            }
            System.out.print(r);
        }
        System.out.print("\n");
    }
    public static int[] encontarValores(int[] r,LinkedList<Integer> n){
        int[] res= new int[3];
        boolean sal=false;
        for(int i=0;!sal&&i<n.size();i++){
            for(int j=i+1;!sal&&j<n.size();j++){
                if(n.get(i)*n.get(j)==r[0]){
                    res[0]=n.get(i);
                    res[1]=n.get(j);
                    sal=true;
                    n.remove(i);
                    n.remove(j-1);
                }
            }
        }
        for(int i=0;sal&&i<n.size();i++){
            if(res[1]*n.get(i)==r[1]){
                res[2]= n.get(i);
                n.remove(i);
                sal=false;
            }else{
                if(res[0]*n.get(i)==r[1]){
                    int aux=res[0];
                    res[0]=res[1];
                    res[1]=aux;
                    res[2]= n.get(i);
                    n.remove(i);
                    sal=false;
                }
            }
        }
        return res;
        
    }
    static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader( 
                new InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) { 
                try { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException e) { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() { return Integer.parseInt(next()); } 
  
        long nextLong() { return Long.parseLong(next()); } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try { 
                if(st.hasMoreTokens()){ 
                    str = st.nextToken("\n"); 
                } 
                else{ 
                    str = br.readLine(); 
                } 
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
    
}