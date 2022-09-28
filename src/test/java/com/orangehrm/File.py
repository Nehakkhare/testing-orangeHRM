//f=open("E:\\A.txt","w")
print("File Create successfully.....!")


f=open("E:\\A.txt","w")
f.write("Learn Coding")
print("File Wrote successfully.....!")
print(f.readline())
print(f.readlines())


f=open("E:\\A.txt","r")
print(f.read(10))