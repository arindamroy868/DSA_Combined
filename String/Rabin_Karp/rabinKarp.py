# Time complexity => Best Case - O(n+m) and Worst Case - O(nm)
d = 256

def rabinKarpAlgo(txt, pat, q):
    n = len(txt)
    m = len(pat)
    t = 0 # hash value for text
    p = 0 # hash value for pattern
    h = 1

    for _ in range(m-1):
        h = (h*d)%q

    for i in range(m):
        p = (d*p + ord(pat[i]))%q
        t = (d*t + ord(txt[i]))%q

    for i in range(n-m+1):

        if p == t:
            for j in range(m):
                if txt[i+j] != pat[j]:
                    break

            if m == j+1:
                print("Pattern found at index : ", i)
        
        if i < n-m:
            t = ((d *(t - ord(txt[i])*h)) + ord(txt[i+m]))%q

            if t < 0:
                t += q


txt = input("Enter the text : ")
pat = input("Enter the pattern to be match : ")
q = 101 # take high prime no. to perform modulo on hash that will reduce the hash collision

rabinKarpAlgo(txt, pat, q)