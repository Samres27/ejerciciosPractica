/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.divideyvenceras;

/**
 *
 * @author SAMUEL
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Publica
 */
public class ejercicio3  {
    static int[] list;
    static Set<Long> sums;
    public static void main(String[] abc) throws FileNotFoundException{
        FastReader sc= new FastReader();
        int t= sc.nextInt();
        while(t-->0){
           int n= sc.nextInt();
           int q=sc.nextInt();
           list=new int[n];
           for(int i=0; i<n;i++){
               list[i]=sc.nextInt();
           }
           Arrays.sort(list);
            //mergesort(list,0,list.length-1);
           //encontar todas las sumas posibles}
           sums=new HashSet<>();
           
           encontarSumas(0,n-1);
           for(int i=0;i<q;i++){
               if(sums.contains(sc.nextLong())){
                   System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
                
           }
           
        }
    }
    
    public static void mergesort(int A[],int izq, int der){
        if (izq < der){
                int m=(izq+der)/2;
                mergesort(A,izq, m);
                mergesort(A,m+1, der);                                                                                
                merge(A,izq, m, der);                                                                                 
        }
    
    }
    public static void merge(int A[],int izq, int m, int der){
        int i, j, k;
        int [] B = new int[A.length]; //array auxiliar
        for (i=izq; i<=der; i++)      //copia ambas mitades en el array auxiliar                                       
             B[i]=A[i];

        i=izq; j=m+1; k=izq;

        while (i<=m && j<=der) //copia el siguiente elemento más grande                                      
               if (B[i]<=B[j])
                   A[k++]=B[i++];
               else
                   A[k++]=B[j++];

        while (i<=m)         //copia los elementos que quedan de la
              A[k++]=B[i++]; //primera mitad (si los hay)
     }
    public static void encontarSumas(int l,int r){
        long sum=0;
        for(int i=l;i<=r;i++){
            sum+=list[i];
        }
        sums.add(sum);
        int medio= (list[l]+list[r])/2;
        int pos=-1;
        for(int i=l;i<=r;i++){
            if(list[i]<=medio){
                    pos=i;
            }else{
                break;
            }
        }
        if(pos==-1||pos==r){
            return ;
        }
        encontarSumas(l, pos);
        encontarSumas(pos+1,r);
        
    }
     static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() throws FileNotFoundException 
        { 
            br = new BufferedReader( 
                //new InputStreamReader(System.in)); 
                   new FileReader("C:\\Users\\SAMUEL\\Documents\\4to semestre\\alg avan\\1510\\ej3.txt"));
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

