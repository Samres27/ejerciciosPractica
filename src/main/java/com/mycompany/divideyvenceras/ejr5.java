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
public class ejr5 {
    static int n1=200005;
    static int ls[]=new int[n1];
    static long[][] segmt=new long[4*n1][4];
    static  long ans;
    static int k;
    static FastReader sc= new FastReader();
    static void main (String[] abc){
         int n,q,t,l,r;
    n=sc.nextInt();
    q=sc.nextInt();
    build(0,1,n);
    while (q-->0)
    {
        
        t=sc.nextInt();
        l=sc.nextInt();
        r=sc.nextInt();
        if (t==1)
            actualizar(0,1,n,l,r);
        else
        {
            ans=k=0;
            consultar(0,1,n,l,r);
            System.out.println(ans+fun(k));
        }
    }
    }
    static long fun(int x){
        return (1*x*(x+1))/2;
    }
    static void calcular(int i,int l,int r){
         int m=l+(r-l)/2;
    if (segmt[i*2+1][3]==1&&segmt[i*2+2][3]==1)
    {
        if (ls[m]>ls[m+1])
        {
            segmt[i][0]=0;
            segmt[i][1]=(r-l)/2+1;
            segmt[i][2]=r-l-(r-l)/2;
            segmt[i][3]=0;
        }
        else
        {
            segmt[i][0]=0;
            segmt[i][1]=0;
            segmt[i][2]=0;
            segmt[i][3]=1;
        }
    }else if (segmt[i*2+1][3]==1)
    {
        if (ls[m]>ls[m+1])
        {
            segmt[i][0]=segmt[i*2+2][0]+fun((int)segmt[i*2+2][1]);
            segmt[i][1]=(r-l)/2+1;
            segmt[i][2]=segmt[i*2+2][2];
            segmt[i][3]=0;
        }
        else
        {
            segmt[i][0]=segmt[i*2+2][0];
            segmt[i][1]=(r-l)/2+1+segmt[i*2+2][1];
            segmt[i][2]=segmt[i*2+2][2];
            segmt[i][3]=0;
        }
    }
    else if (segmt[i*2+2][3]==1)
    {
        if (ls[m]>ls[m+1])
        {
            segmt[i][0]=segmt[i*2+1][0]+fun((int)segmt[i*2+1][2]);
            segmt[i][1]=segmt[i*2+1][1];
            segmt[i][2]=r-l-(r-l)/2;
            segmt[i][3]=0;
        }
        else
        {
            segmt[i][0]=segmt[i*2+1][0];
            segmt[i][1]=segmt[i*2+1][1];
            segmt[i][2]=r-l-(r-l)/2+segmt[i*2+1][2];
            segmt[i][3]=0;
        }
    }
    else
    {
        if (ls[m]>ls[m+1])
        {
            segmt[i][0]=segmt[i*2+1][0]+segmt[i*2+2][0]+fun((int)segmt[i*2+1][2])+fun((int)segmt[i*2+2][1]);
            segmt[i][1]=segmt[i*2+1][1];
            segmt[i][2]=segmt[i*2+2][2];
            segmt[i][3]=0;
        }
        else
        {
            segmt[i][0]=segmt[i*2+1][0]+segmt[i*2+2][0]+fun((int)segmt[i*2+1][2]+(int)segmt[i*2+2][1]);
            segmt[i][1]=segmt[i*2+1][1];
            segmt[i][2]=segmt[i*2+2][2];
            segmt[i][3]=0;
        }
    }
    }
   static void build(int i, int l, int r)
{
    if (l==r)
    {
        ls[l]=sc.nextInt();
        segmt[i][3]=1;
        return;
    }
    build(i*2+1,l,l+(r-l)/2);
    build(i*2+2,l+(r-l)/2+1,r);
    calcular(i,l,r);
}
static void actualizar(int i, int l, int r, int x, int y)
{
    if (l==r)
    {
        ls[x]=y;
        return;
    }
    if (x<=l+(r-l)/2)
        actualizar(i*2+1,l,l+(r-l)/2,x,y);
    else
        actualizar(i*2+2,l+(r-l)/2+1,r,x,y);
    calcular(i,l,r);
} 
static void consultar(int i, int l, int r, int qL, int qR)
{
    if (r<qL||qR<l)
        return;
    if (qL<=l&&r<=qR)
    {
        if (segmt[i][3]==1)
        {
            if (ls[l-1]>ls[l])
            {
                ans+=fun(k);
                k=r-l+1;
            }
            else
                k+=r-l+1;
        }
        else
        {
            if (ls[l-1]>ls[l])
                ans+=segmt[i][0]+fun(k)+fun((int)segmt[i][1]);
            else
                ans+=segmt[i][0]+fun(k+(int)segmt[i][1]);
            k=(int)segmt[i][2];
        }
        return;
    }
    consultar(i*2+1,l,l+(r-l)/2,qL,qR);
    consultar(i*2+2,l+(r-l)/2+1,r,qL,qR);
}
static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader( 
                new InputStreamReader(System.in)); 
                //   new FileReader("C:\\Users\\SAMUEL\\Documents\\4to semestre\\alg avan\\1510\\ej4.txt"));
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
