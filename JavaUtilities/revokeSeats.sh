a=`grep -E "\"Id\":" test.txt | cut -d"," -f1 | cut -d":" -f2 | tr -d [:blank:]` 
grep -E "\"SubscriptionId\":" test.txt | cut -d"," -f1 | cut -d":" -f2 | tr -d [:blank:] > subIds.txt
#cat test.txt | tr -d [:blank:]
echo $a | tr ' ' , > result.txt
cat subIds.txt | uniq > uniqueSubIds.txt
rm subIds.txt
for i in `cat uniqueSubIds.txt`
do
   echo db2 \"Update db2saas.subscription $i lll \($i\)\" >> result.txt
done
echo "Done. check result.txt"
