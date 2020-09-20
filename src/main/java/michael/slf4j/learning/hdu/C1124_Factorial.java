package michael.slf4j.learning.hdu;

import java.util.Scanner;

public class C1124_Factorial {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int testcase = sc.nextInt();
			while(testcase-- > 0) {
				long n = sc.nextLong();
				System.out.println(count(n));
			}
		}
	}
	
	public static int count(long n) {
		int count = 0;
		long start = 0;
		if(n >= 1000000000){
			count = 249999998;start = 1000000000;
			}else if(n >= 999500000){
			count = 249874996;start = 999500000;
			}else if(n >= 999000000){
			count = 249749997;start = 999000000;
			}else if(n >= 998500000){
			count = 249624997;start = 998500000;
			}else if(n >= 998000000){
			count = 249499996;start = 998000000;
			}else if(n >= 997500000){
			count = 249374997;start = 997500000;
			}else if(n >= 997000000){
			count = 249249997;start = 997000000;
			}else if(n >= 996500000){
			count = 249124998;start = 996500000;
			}else if(n >= 996000000){
			count = 248999995;start = 996000000;
			}else if(n >= 995500000){
			count = 248874996;start = 995500000;
			}else if(n >= 995000000){
			count = 248749997;start = 995000000;
			}else if(n >= 994500000){
			count = 248624996;start = 994500000;
			}else if(n >= 994000000){
			count = 248499996;start = 994000000;
			}else if(n >= 993500000){
			count = 248374996;start = 993500000;
			}else if(n >= 993000000){
			count = 248249997;start = 993000000;
			}else if(n >= 992500000){
			count = 248124997;start = 992500000;
			}else if(n >= 992000000){
			count = 247999996;start = 992000000;
			}else if(n >= 991500000){
			count = 247874997;start = 991500000;
			}else if(n >= 991000000){
			count = 247749996;start = 991000000;
			}else if(n >= 990500000){
			count = 247624997;start = 990500000;
			}else if(n >= 990000000){
			count = 247499997;start = 990000000;
			}else if(n >= 989500000){
			count = 247374997;start = 989500000;
			}else if(n >= 989000000){
			count = 247249997;start = 989000000;
			}else if(n >= 988500000){
			count = 247124997;start = 988500000;
			}else if(n >= 988000000){
			count = 246999997;start = 988000000;
			}else if(n >= 987500000){
			count = 246874998;start = 987500000;
			}else if(n >= 987000000){
			count = 246749997;start = 987000000;
			}else if(n >= 986500000){
			count = 246624998;start = 986500000;
			}else if(n >= 986000000){
			count = 246499996;start = 986000000;
			}else if(n >= 985500000){
			count = 246374996;start = 985500000;
			}else if(n >= 985000000){
			count = 246249997;start = 985000000;
			}else if(n >= 984500000){
			count = 246124997;start = 984500000;
			}else if(n >= 984000000){
			count = 245999997;start = 984000000;
			}else if(n >= 983500000){
			count = 245874996;start = 983500000;
			}else if(n >= 983000000){
			count = 245749997;start = 983000000;
			}else if(n >= 982500000){
			count = 245624998;start = 982500000;
			}else if(n >= 982000000){
			count = 245499996;start = 982000000;
			}else if(n >= 981500000){
			count = 245374997;start = 981500000;
			}else if(n >= 981000000){
			count = 245249997;start = 981000000;
			}else if(n >= 980500000){
			count = 245124998;start = 980500000;
			}else if(n >= 980000000){
			count = 244999997;start = 980000000;
			}else if(n >= 979500000){
			count = 244874997;start = 979500000;
			}else if(n >= 979000000){
			count = 244749998;start = 979000000;
			}else if(n >= 978500000){
			count = 244624996;start = 978500000;
			}else if(n >= 978000000){
			count = 244499997;start = 978000000;
			}else if(n >= 977500000){
			count = 244374998;start = 977500000;
			}else if(n >= 977000000){
			count = 244249998;start = 977000000;
			}else if(n >= 976500000){
			count = 244124994;start = 976500000;
			}else if(n >= 976000000){
			count = 243999994;start = 976000000;
			}else if(n >= 975500000){
			count = 243874995;start = 975500000;
			}else if(n >= 975000000){
			count = 243749996;start = 975000000;
			}else if(n >= 974500000){
			count = 243624994;start = 974500000;
			}else if(n >= 974000000){
			count = 243499995;start = 974000000;
			}else if(n >= 973500000){
			count = 243374995;start = 973500000;
			}else if(n >= 973000000){
			count = 243249995;start = 973000000;
			}else if(n >= 972500000){
			count = 243124995;start = 972500000;
			}else if(n >= 972000000){
			count = 242999995;start = 972000000;
			}else if(n >= 971500000){
			count = 242874996;start = 971500000;
			}else if(n >= 971000000){
			count = 242749995;start = 971000000;
			}else if(n >= 970500000){
			count = 242624995;start = 970500000;
			}else if(n >= 970000000){
			count = 242499996;start = 970000000;
			}else if(n >= 969500000){
			count = 242374995;start = 969500000;
			}else if(n >= 969000000){
			count = 242249996;start = 969000000;
			}else if(n >= 968500000){
			count = 242124995;start = 968500000;
			}else if(n >= 968000000){
			count = 241999996;start = 968000000;
			}else if(n >= 967500000){
			count = 241874996;start = 967500000;
			}else if(n >= 967000000){
			count = 241749996;start = 967000000;
			}else if(n >= 966500000){
			count = 241624995;start = 966500000;
			}else if(n >= 966000000){
			count = 241499994;start = 966000000;
			}else if(n >= 965500000){
			count = 241374995;start = 965500000;
			}else if(n >= 965000000){
			count = 241249996;start = 965000000;
			}else if(n >= 964500000){
			count = 241124995;start = 964500000;
			}else if(n >= 964000000){
			count = 240999995;start = 964000000;
			}else if(n >= 963500000){
			count = 240874995;start = 963500000;
			}else if(n >= 963000000){
			count = 240749996;start = 963000000;
			}else if(n >= 962500000){
			count = 240624996;start = 962500000;
			}else if(n >= 962000000){
			count = 240499995;start = 962000000;
			}else if(n >= 961500000){
			count = 240374996;start = 961500000;
			}else if(n >= 961000000){
			count = 240249996;start = 961000000;
			}else if(n >= 960500000){
			count = 240124995;start = 960500000;
			}else if(n >= 960000000){
			count = 239999996;start = 960000000;
			}else if(n >= 959500000){
			count = 239874996;start = 959500000;
			}else if(n >= 959000000){
			count = 239749997;start = 959000000;
			}else if(n >= 958500000){
			count = 239624995;start = 958500000;
			}else if(n >= 958000000){
			count = 239499996;start = 958000000;
			}else if(n >= 957500000){
			count = 239374997;start = 957500000;
			}else if(n >= 957000000){
			count = 239249994;start = 957000000;
			}else if(n >= 956500000){
			count = 239124995;start = 956500000;
			}else if(n >= 956000000){
			count = 238999995;start = 956000000;
			}else if(n >= 955500000){
			count = 238874996;start = 955500000;
			}else if(n >= 955000000){
			count = 238749995;start = 955000000;
			}else if(n >= 954500000){
			count = 238624995;start = 954500000;
			}else if(n >= 954000000){
			count = 238499996;start = 954000000;
			}else if(n >= 953500000){
			count = 238374995;start = 953500000;
			}else if(n >= 953000000){
			count = 238249995;start = 953000000;
			}else if(n >= 952500000){
			count = 238124996;start = 952500000;
			}else if(n >= 952000000){
			count = 237999996;start = 952000000;
			}else if(n >= 951500000){
			count = 237874996;start = 951500000;
			}else if(n >= 951000000){
			count = 237749995;start = 951000000;
			}else if(n >= 950500000){
			count = 237624996;start = 950500000;
			}else if(n >= 950000000){
			count = 237499997;start = 950000000;
			}else if(n >= 949500000){
			count = 237374996;start = 949500000;
			}else if(n >= 949000000){
			count = 237249996;start = 949000000;
			}else if(n >= 948500000){
			count = 237124996;start = 948500000;
			}else if(n >= 948000000){
			count = 236999996;start = 948000000;
			}else if(n >= 947500000){
			count = 236874997;start = 947500000;
			}else if(n >= 947000000){
			count = 236749995;start = 947000000;
			}else if(n >= 946500000){
			count = 236624996;start = 946500000;
			}else if(n >= 946000000){
			count = 236499995;start = 946000000;
			}else if(n >= 945500000){
			count = 236374996;start = 945500000;
			}else if(n >= 945000000){
			count = 236249996;start = 945000000;
			}else if(n >= 944500000){
			count = 236124995;start = 944500000;
			}else if(n >= 944000000){
			count = 235999996;start = 944000000;
			}else if(n >= 943500000){
			count = 235874996;start = 943500000;
			}else if(n >= 943000000){
			count = 235749996;start = 943000000;
			}else if(n >= 942500000){
			count = 235624996;start = 942500000;
			}else if(n >= 942000000){
			count = 235499996;start = 942000000;
			}else if(n >= 941500000){
			count = 235374997;start = 941500000;
			}else if(n >= 941000000){
			count = 235249995;start = 941000000;
			}else if(n >= 940500000){
			count = 235124996;start = 940500000;
			}else if(n >= 940000000){
			count = 234999997;start = 940000000;
			}else if(n >= 939500000){
			count = 234874997;start = 939500000;
			}else if(n >= 939000000){
			count = 234749996;start = 939000000;
			}else if(n >= 938500000){
			count = 234624996;start = 938500000;
			}else if(n >= 938000000){
			count = 234499997;start = 938000000;
			}else if(n >= 937500000){
			count = 234374998;start = 937500000;
			}else if(n >= 937000000){
			count = 234249995;start = 937000000;
			}else if(n >= 936500000){
			count = 234124996;start = 936500000;
			}else if(n >= 936000000){
			count = 233999996;start = 936000000;
			}else if(n >= 935500000){
			count = 233874995;start = 935500000;
			}else if(n >= 935000000){
			count = 233749996;start = 935000000;
			}else if(n >= 934500000){
			count = 233624996;start = 934500000;
			}else if(n >= 934000000){
			count = 233499997;start = 934000000;
			}else if(n >= 933500000){
			count = 233374995;start = 933500000;
			}else if(n >= 933000000){
			count = 233249996;start = 933000000;
			}else if(n >= 932500000){
			count = 233124997;start = 932500000;
			}else if(n >= 932000000){
			count = 232999996;start = 932000000;
			}else if(n >= 931500000){
			count = 232874996;start = 931500000;
			}else if(n >= 931000000){
			count = 232749996;start = 931000000;
			}else if(n >= 930500000){
			count = 232624997;start = 930500000;
			}else if(n >= 930000000){
			count = 232499997;start = 930000000;
			}else if(n >= 929500000){
			count = 232374996;start = 929500000;
			}else if(n >= 929000000){
			count = 232249997;start = 929000000;
			}else if(n >= 928500000){
			count = 232124996;start = 928500000;
			}else if(n >= 928000000){
			count = 231999997;start = 928000000;
			}else if(n >= 927500000){
			count = 231874995;start = 927500000;
			}else if(n >= 927000000){
			count = 231749995;start = 927000000;
			}else if(n >= 926500000){
			count = 231624995;start = 926500000;
			}else if(n >= 926000000){
			count = 231499995;start = 926000000;
			}else if(n >= 925500000){
			count = 231374995;start = 925500000;
			}else if(n >= 925000000){
			count = 231249996;start = 925000000;
			}else if(n >= 924500000){
			count = 231124995;start = 924500000;
			}else if(n >= 924000000){
			count = 230999996;start = 924000000;
			}else if(n >= 923500000){
			count = 230874995;start = 923500000;
			}else if(n >= 923000000){
			count = 230749995;start = 923000000;
			}else if(n >= 922500000){
			count = 230624996;start = 922500000;
			}else if(n >= 922000000){
			count = 230499996;start = 922000000;
			}else if(n >= 921500000){
			count = 230374996;start = 921500000;
			}else if(n >= 921000000){
			count = 230249995;start = 921000000;
			}else if(n >= 920500000){
			count = 230124996;start = 920500000;
			}else if(n >= 920000000){
			count = 229999997;start = 920000000;
			}else if(n >= 919500000){
			count = 229874995;start = 919500000;
			}else if(n >= 919000000){
			count = 229749996;start = 919000000;
			}else if(n >= 918500000){
			count = 229624996;start = 918500000;
			}else if(n >= 918000000){
			count = 229499997;start = 918000000;
			}else if(n >= 917500000){
			count = 229374995;start = 917500000;
			}else if(n >= 917000000){
			count = 229249995;start = 917000000;
			}else if(n >= 916500000){
			count = 229124996;start = 916500000;
			}else if(n >= 916000000){
			count = 228999994;start = 916000000;
			}else if(n >= 915500000){
			count = 228874995;start = 915500000;
			}else if(n >= 915000000){
			count = 228749996;start = 915000000;
			}else if(n >= 914500000){
			count = 228624996;start = 914500000;
			}else if(n >= 914000000){
			count = 228499995;start = 914000000;
			}else if(n >= 913500000){
			count = 228374995;start = 913500000;
			}else if(n >= 913000000){
			count = 228249996;start = 913000000;
			}else if(n >= 912500000){
			count = 228124997;start = 912500000;
			}else if(n >= 912000000){
			count = 227999995;start = 912000000;
			}else if(n >= 911500000){
			count = 227874996;start = 911500000;
			}else if(n >= 911000000){
			count = 227749996;start = 911000000;
			}else if(n >= 910500000){
			count = 227624996;start = 910500000;
			}else if(n >= 910000000){
			count = 227499996;start = 910000000;
			}else if(n >= 909500000){
			count = 227374996;start = 909500000;
			}else if(n >= 909000000){
			count = 227249997;start = 909000000;
			}else if(n >= 908500000){
			count = 227124996;start = 908500000;
			}else if(n >= 908000000){
			count = 226999995;start = 908000000;
			}else if(n >= 907500000){
			count = 226874996;start = 907500000;
			}else if(n >= 907000000){
			count = 226749995;start = 907000000;
			}else if(n >= 906500000){
			count = 226624996;start = 906500000;
			}else if(n >= 906000000){
			count = 226499995;start = 906000000;
			}else if(n >= 905500000){
			count = 226374996;start = 905500000;
			}else if(n >= 905000000){
			count = 226249996;start = 905000000;
			}else if(n >= 904500000){
			count = 226124996;start = 904500000;
			}else if(n >= 904000000){
			count = 225999996;start = 904000000;
			}else if(n >= 903500000){
			count = 225874995;start = 903500000;
			}else if(n >= 903000000){
			count = 225749996;start = 903000000;
			}else if(n >= 902500000){
			count = 225624997;start = 902500000;
			}else if(n >= 902000000){
			count = 225499996;start = 902000000;
			}else if(n >= 901500000){
			count = 225374996;start = 901500000;
			}else if(n >= 901000000){
			count = 225249996;start = 901000000;
			}else if(n >= 900500000){
			count = 225124997;start = 900500000;
			}else if(n >= 900000000){
			count = 224999997;start = 900000000;
			}else if(n >= 899500000){
			count = 224874996;start = 899500000;
			}else if(n >= 899000000){
			count = 224749997;start = 899000000;
			}else if(n >= 898500000){
			count = 224624997;start = 898500000;
			}else if(n >= 898000000){
			count = 224499995;start = 898000000;
			}else if(n >= 897500000){
			count = 224374996;start = 897500000;
			}else if(n >= 897000000){
			count = 224249996;start = 897000000;
			}else if(n >= 896500000){
			count = 224124997;start = 896500000;
			}else if(n >= 896000000){
			count = 223999995;start = 896000000;
			}else if(n >= 895500000){
			count = 223874996;start = 895500000;
			}else if(n >= 895000000){
			count = 223749997;start = 895000000;
			}else if(n >= 894500000){
			count = 223624995;start = 894500000;
			}else if(n >= 894000000){
			count = 223499996;start = 894000000;
			}else if(n >= 893500000){
			count = 223374996;start = 893500000;
			}else if(n >= 893000000){
			count = 223249997;start = 893000000;
			}else if(n >= 892500000){
			count = 223124996;start = 892500000;
			}else if(n >= 892000000){
			count = 222999996;start = 892000000;
			}else if(n >= 891500000){
			count = 222874997;start = 891500000;
			}else if(n >= 891000000){
			count = 222749996;start = 891000000;
			}else if(n >= 890500000){
			count = 222624996;start = 890500000;
			}else if(n >= 890000000){
			count = 222499997;start = 890000000;
			}else if(n >= 889500000){
			count = 222374997;start = 889500000;
			}else if(n >= 889000000){
			count = 222249997;start = 889000000;
			}else if(n >= 888500000){
			count = 222124995;start = 888500000;
			}else if(n >= 888000000){
			count = 221999996;start = 888000000;
			}else if(n >= 887500000){
			count = 221874997;start = 887500000;
			}else if(n >= 887000000){
			count = 221749996;start = 887000000;
			}else if(n >= 886500000){
			count = 221624996;start = 886500000;
			}else if(n >= 886000000){
			count = 221499996;start = 886000000;
			}else if(n >= 885500000){
			count = 221374996;start = 885500000;
			}else if(n >= 885000000){
			count = 221249997;start = 885000000;
			}else if(n >= 884500000){
			count = 221124996;start = 884500000;
			}else if(n >= 884000000){
			count = 220999997;start = 884000000;
			}else if(n >= 883500000){
			count = 220874996;start = 883500000;
			}else if(n >= 883000000){
			count = 220749997;start = 883000000;
			}else if(n >= 882500000){
			count = 220624997;start = 882500000;
			}else if(n >= 882000000){
			count = 220499996;start = 882000000;
			}else if(n >= 881500000){
			count = 220374997;start = 881500000;
			}else if(n >= 881000000){
			count = 220249997;start = 881000000;
			}else if(n >= 880500000){
			count = 220124997;start = 880500000;
			}else if(n >= 880000000){
			count = 219999997;start = 880000000;
			}else if(n >= 879500000){
			count = 219874997;start = 879500000;
			}else if(n >= 879000000){
			count = 219749998;start = 879000000;
			}else if(n >= 878500000){
			count = 219624994;start = 878500000;
			}else if(n >= 878000000){
			count = 219499995;start = 878000000;
			}else if(n >= 877500000){
			count = 219374996;start = 877500000;
			}else if(n >= 877000000){
			count = 219249996;start = 877000000;
			}else if(n >= 876500000){
			count = 219124995;start = 876500000;
			}else if(n >= 876000000){
			count = 218999995;start = 876000000;
			}else if(n >= 875500000){
			count = 218874996;start = 875500000;
			}else if(n >= 875000000){
			count = 218749997;start = 875000000;
			}else if(n >= 874500000){
			count = 218624995;start = 874500000;
			}else if(n >= 874000000){
			count = 218499996;start = 874000000;
			}else if(n >= 873500000){
			count = 218374996;start = 873500000;
			}else if(n >= 873000000){
			count = 218249995;start = 873000000;
			}else if(n >= 872500000){
			count = 218124996;start = 872500000;
			}else if(n >= 872000000){
			count = 217999996;start = 872000000;
			}else if(n >= 871500000){
			count = 217874997;start = 871500000;
			}else if(n >= 871000000){
			count = 217749995;start = 871000000;
			}else if(n >= 870500000){
			count = 217624996;start = 870500000;
			}else if(n >= 870000000){
			count = 217499997;start = 870000000;
			}else if(n >= 869500000){
			count = 217374996;start = 869500000;
			}else if(n >= 869000000){
			count = 217249995;start = 869000000;
			}else if(n >= 868500000){
			count = 217124995;start = 868500000;
			}else if(n >= 868000000){
			count = 216999996;start = 868000000;
			}else if(n >= 867500000){
			count = 216874996;start = 867500000;
			}else if(n >= 867000000){
			count = 216749995;start = 867000000;
			}else if(n >= 866500000){
			count = 216624996;start = 866500000;
			}else if(n >= 866000000){
			count = 216499995;start = 866000000;
			}else if(n >= 865500000){
			count = 216374996;start = 865500000;
			}else if(n >= 865000000){
			count = 216249996;start = 865000000;
			}else if(n >= 864500000){
			count = 216124996;start = 864500000;
			}else if(n >= 864000000){
			count = 215999996;start = 864000000;
			}else if(n >= 863500000){
			count = 215874996;start = 863500000;
			}else if(n >= 863000000){
			count = 215749996;start = 863000000;
			}else if(n >= 862500000){
			count = 215624997;start = 862500000;
			}else if(n >= 862000000){
			count = 215499996;start = 862000000;
			}else if(n >= 861500000){
			count = 215374997;start = 861500000;
			}else if(n >= 861000000){
			count = 215249996;start = 861000000;
			}else if(n >= 860500000){
			count = 215124996;start = 860500000;
			}else if(n >= 860000000){
			count = 214999997;start = 860000000;
			}else if(n >= 859500000){
			count = 214874997;start = 859500000;
			}else if(n >= 859000000){
			count = 214749996;start = 859000000;
			}else if(n >= 858500000){
			count = 214624995;start = 858500000;
			}else if(n >= 858000000){
			count = 214499996;start = 858000000;
			}else if(n >= 857500000){
			count = 214374997;start = 857500000;
			}else if(n >= 857000000){
			count = 214249995;start = 857000000;
			}else if(n >= 856500000){
			count = 214124996;start = 856500000;
			}else if(n >= 856000000){
			count = 213999996;start = 856000000;
			}else if(n >= 855500000){
			count = 213874997;start = 855500000;
			}else if(n >= 855000000){
			count = 213749996;start = 855000000;
			}else if(n >= 854500000){
			count = 213624996;start = 854500000;
			}else if(n >= 854000000){
			count = 213499997;start = 854000000;
			}else if(n >= 853500000){
			count = 213374995;start = 853500000;
			}else if(n >= 853000000){
			count = 213249996;start = 853000000;
			}else if(n >= 852500000){
			count = 213124997;start = 852500000;
			}else if(n >= 852000000){
			count = 212999997;start = 852000000;
			}else if(n >= 851500000){
			count = 212874996;start = 851500000;
			}else if(n >= 851000000){
			count = 212749996;start = 851000000;
			}else if(n >= 850500000){
			count = 212624997;start = 850500000;
			}else if(n >= 850000000){
			count = 212499998;start = 850000000;
			}else if(n >= 849500000){
			count = 212374995;start = 849500000;
			}else if(n >= 849000000){
			count = 212249996;start = 849000000;
			}else if(n >= 848500000){
			count = 212124996;start = 848500000;
			}else if(n >= 848000000){
			count = 211999996;start = 848000000;
			}else if(n >= 847500000){
			count = 211874996;start = 847500000;
			}else if(n >= 847000000){
			count = 211749996;start = 847000000;
			}else if(n >= 846500000){
			count = 211624997;start = 846500000;
			}else if(n >= 846000000){
			count = 211499996;start = 846000000;
			}else if(n >= 845500000){
			count = 211374996;start = 845500000;
			}else if(n >= 845000000){
			count = 211249997;start = 845000000;
			}else if(n >= 844500000){
			count = 211124996;start = 844500000;
			}else if(n >= 844000000){
			count = 210999997;start = 844000000;
			}else if(n >= 843500000){
			count = 210874996;start = 843500000;
			}else if(n >= 843000000){
			count = 210749997;start = 843000000;
			}else if(n >= 842500000){
			count = 210624997;start = 842500000;
			}else if(n >= 842000000){
			count = 210499997;start = 842000000;
			}else if(n >= 841500000){
			count = 210374997;start = 841500000;
			}else if(n >= 841000000){
			count = 210249996;start = 841000000;
			}else if(n >= 840500000){
			count = 210124997;start = 840500000;
			}else if(n >= 840000000){
			count = 209999998;start = 840000000;
			}else if(n >= 839500000){
			count = 209874996;start = 839500000;
			}else if(n >= 839000000){
			count = 209749996;start = 839000000;
			}else if(n >= 838500000){
			count = 209624996;start = 838500000;
			}else if(n >= 838000000){
			count = 209499997;start = 838000000;
			}else if(n >= 837500000){
			count = 209374997;start = 837500000;
			}else if(n >= 837000000){
			count = 209249996;start = 837000000;
			}else if(n >= 836500000){
			count = 209124997;start = 836500000;
			}else if(n >= 836000000){
			count = 208999997;start = 836000000;
			}else if(n >= 835500000){
			count = 208874996;start = 835500000;
			}else if(n >= 835000000){
			count = 208749997;start = 835000000;
			}else if(n >= 834500000){
			count = 208624997;start = 834500000;
			}else if(n >= 834000000){
			count = 208499998;start = 834000000;
			}else if(n >= 833500000){
			count = 208374996;start = 833500000;
			}else if(n >= 833000000){
			count = 208249997;start = 833000000;
			}else if(n >= 832500000){
			count = 208124998;start = 832500000;
			}else if(n >= 832000000){
			count = 207999996;start = 832000000;
			}else if(n >= 831500000){
			count = 207874997;start = 831500000;
			}else if(n >= 831000000){
			count = 207749997;start = 831000000;
			}else if(n >= 830500000){
			count = 207624998;start = 830500000;
			}else if(n >= 830000000){
			count = 207499995;start = 830000000;
			}else if(n >= 829500000){
			count = 207374995;start = 829500000;
			}else if(n >= 829000000){
			count = 207249996;start = 829000000;
			}else if(n >= 828500000){
			count = 207124995;start = 828500000;
			}else if(n >= 828000000){
			count = 206999995;start = 828000000;
			}else if(n >= 827500000){
			count = 206874996;start = 827500000;
			}else if(n >= 827000000){
			count = 206749996;start = 827000000;
			}else if(n >= 826500000){
			count = 206624996;start = 826500000;
			}else if(n >= 826000000){
			count = 206499995;start = 826000000;
			}else if(n >= 825500000){
			count = 206374996;start = 825500000;
			}else if(n >= 825000000){
			count = 206249997;start = 825000000;
			}else if(n >= 824500000){
			count = 206124996;start = 824500000;
			}else if(n >= 824000000){
			count = 205999996;start = 824000000;
			}else if(n >= 823500000){
			count = 205874996;start = 823500000;
			}else if(n >= 823000000){
			count = 205749996;start = 823000000;
			}else if(n >= 822500000){
			count = 205624997;start = 822500000;
			}else if(n >= 822000000){
			count = 205499996;start = 822000000;
			}else if(n >= 821500000){
			count = 205374997;start = 821500000;
			}else if(n >= 821000000){
			count = 205249996;start = 821000000;
			}else if(n >= 820500000){
			count = 205124997;start = 820500000;
			}else if(n >= 820000000){
			count = 204999996;start = 820000000;
			}else if(n >= 819500000){
			count = 204874995;start = 819500000;
			}else if(n >= 819000000){
			count = 204749996;start = 819000000;
			}else if(n >= 818500000){
			count = 204624996;start = 818500000;
			}else if(n >= 818000000){
			count = 204499996;start = 818000000;
			}else if(n >= 817500000){
			count = 204374996;start = 817500000;
			}else if(n >= 817000000){
			count = 204249996;start = 817000000;
			}else if(n >= 816500000){
			count = 204124997;start = 816500000;
			}else if(n >= 816000000){
			count = 203999995;start = 816000000;
			}else if(n >= 815500000){
			count = 203874996;start = 815500000;
			}else if(n >= 815000000){
			count = 203749997;start = 815000000;
			}else if(n >= 814500000){
			count = 203624997;start = 814500000;
			}else if(n >= 814000000){
			count = 203499996;start = 814000000;
			}else if(n >= 813500000){
			count = 203374996;start = 813500000;
			}else if(n >= 813000000){
			count = 203249997;start = 813000000;
			}else if(n >= 812500000){
			count = 203124998;start = 812500000;
			}else if(n >= 812000000){
			count = 202999996;start = 812000000;
			}else if(n >= 811500000){
			count = 202874997;start = 811500000;
			}else if(n >= 811000000){
			count = 202749997;start = 811000000;
			}else if(n >= 810500000){
			count = 202624995;start = 810500000;
			}else if(n >= 810000000){
			count = 202499996;start = 810000000;
			}else if(n >= 809500000){
			count = 202374996;start = 809500000;
			}else if(n >= 809000000){
			count = 202249997;start = 809000000;
			}else if(n >= 808500000){
			count = 202124995;start = 808500000;
			}else if(n >= 808000000){
			count = 201999996;start = 808000000;
			}else if(n >= 807500000){
			count = 201874997;start = 807500000;
			}else if(n >= 807000000){
			count = 201749996;start = 807000000;
			}else if(n >= 806500000){
			count = 201624996;start = 806500000;
			}else if(n >= 806000000){
			count = 201499996;start = 806000000;
			}else if(n >= 805500000){
			count = 201374997;start = 805500000;
			}else if(n >= 805000000){
			count = 201249997;start = 805000000;
			}else if(n >= 804500000){
			count = 201124996;start = 804500000;
			}else if(n >= 804000000){
			count = 200999997;start = 804000000;
			}else if(n >= 803500000){
			count = 200874996;start = 803500000;
			}else if(n >= 803000000){
			count = 200749997;start = 803000000;
			}else if(n >= 802500000){
			count = 200624997;start = 802500000;
			}else if(n >= 802000000){
			count = 200499997;start = 802000000;
			}else if(n >= 801500000){
			count = 200374997;start = 801500000;
			}else if(n >= 801000000){
			count = 200249997;start = 801000000;
			}else if(n >= 800500000){
			count = 200124996;start = 800500000;
			}else if(n >= 800000000){
			count = 199999997;start = 800000000;
			}else if(n >= 799500000){
			count = 199874996;start = 799500000;
			}else if(n >= 799000000){
			count = 199749997;start = 799000000;
			}else if(n >= 798500000){
			count = 199624996;start = 798500000;
			}else if(n >= 798000000){
			count = 199499996;start = 798000000;
			}else if(n >= 797500000){
			count = 199374997;start = 797500000;
			}else if(n >= 797000000){
			count = 199249997;start = 797000000;
			}else if(n >= 796500000){
			count = 199124997;start = 796500000;
			}else if(n >= 796000000){
			count = 198999996;start = 796000000;
			}else if(n >= 795500000){
			count = 198874997;start = 795500000;
			}else if(n >= 795000000){
			count = 198749998;start = 795000000;
			}else if(n >= 794500000){
			count = 198624996;start = 794500000;
			}else if(n >= 794000000){
			count = 198499997;start = 794000000;
			}else if(n >= 793500000){
			count = 198374997;start = 793500000;
			}else if(n >= 793000000){
			count = 198249998;start = 793000000;
			}else if(n >= 792500000){
			count = 198124997;start = 792500000;
			}else if(n >= 792000000){
			count = 197999997;start = 792000000;
			}else if(n >= 791500000){
			count = 197874998;start = 791500000;
			}else if(n >= 791000000){
			count = 197749995;start = 791000000;
			}else if(n >= 790500000){
			count = 197624996;start = 790500000;
			}else if(n >= 790000000){
			count = 197499997;start = 790000000;
			}else if(n >= 789500000){
			count = 197374997;start = 789500000;
			}else if(n >= 789000000){
			count = 197249996;start = 789000000;
			}else if(n >= 788500000){
			count = 197124996;start = 788500000;
			}else if(n >= 788000000){
			count = 196999997;start = 788000000;
			}else if(n >= 787500000){
			count = 196874998;start = 787500000;
			}else if(n >= 787000000){
			count = 196749996;start = 787000000;
			}else if(n >= 786500000){
			count = 196624997;start = 786500000;
			}else if(n >= 786000000){
			count = 196499997;start = 786000000;
			}else if(n >= 785500000){
			count = 196374997;start = 785500000;
			}else if(n >= 785000000){
			count = 196249997;start = 785000000;
			}else if(n >= 784500000){
			count = 196124997;start = 784500000;
			}else if(n >= 784000000){
			count = 195999998;start = 784000000;
			}else if(n >= 783500000){
			count = 195874997;start = 783500000;
			}else if(n >= 783000000){
			count = 195749997;start = 783000000;
			}else if(n >= 782500000){
			count = 195624998;start = 782500000;
			}else if(n >= 782000000){
			count = 195499997;start = 782000000;
			}else if(n >= 781500000){
			count = 195374998;start = 781500000;
			}else if(n >= 781000000){
			count = 195249995;start = 781000000;
			}else if(n >= 780500000){
			count = 195124996;start = 780500000;
			}else if(n >= 780000000){
			count = 194999996;start = 780000000;
			}else if(n >= 779500000){
			count = 194874996;start = 779500000;
			}else if(n >= 779000000){
			count = 194749996;start = 779000000;
			}else if(n >= 778500000){
			count = 194624995;start = 778500000;
			}else if(n >= 778000000){
			count = 194499996;start = 778000000;
			}else if(n >= 777500000){
			count = 194374997;start = 777500000;
			}else if(n >= 777000000){
			count = 194249996;start = 777000000;
			}else if(n >= 776500000){
			count = 194124996;start = 776500000;
			}else if(n >= 776000000){
			count = 193999996;start = 776000000;
			}else if(n >= 775500000){
			count = 193874997;start = 775500000;
			}else if(n >= 775000000){
			count = 193749997;start = 775000000;
			}else if(n >= 774500000){
			count = 193624996;start = 774500000;
			}else if(n >= 774000000){
			count = 193499997;start = 774000000;
			}else if(n >= 773500000){
			count = 193374997;start = 773500000;
			}else if(n >= 773000000){
			count = 193249996;start = 773000000;
			}else if(n >= 772500000){
			count = 193124997;start = 772500000;
			}else if(n >= 772000000){
			count = 192999997;start = 772000000;
			}else if(n >= 771500000){
			count = 192874998;start = 771500000;
			}else if(n >= 771000000){
			count = 192749995;start = 771000000;
			}else if(n >= 770500000){
			count = 192624996;start = 770500000;
			}else if(n >= 770000000){
			count = 192499997;start = 770000000;
			}else if(n >= 769500000){
			count = 192374995;start = 769500000;
			}else if(n >= 769000000){
			count = 192249996;start = 769000000;
			}else if(n >= 768500000){
			count = 192124996;start = 768500000;
			}else if(n >= 768000000){
			count = 191999997;start = 768000000;
			}else if(n >= 767500000){
			count = 191874996;start = 767500000;
			}else if(n >= 767000000){
			count = 191749996;start = 767000000;
			}else if(n >= 766500000){
			count = 191624997;start = 766500000;
			}else if(n >= 766000000){
			count = 191499996;start = 766000000;
			}else if(n >= 765500000){
			count = 191374996;start = 765500000;
			}else if(n >= 765000000){
			count = 191249997;start = 765000000;
			}else if(n >= 764500000){
			count = 191124997;start = 764500000;
			}else if(n >= 764000000){
			count = 190999997;start = 764000000;
			}else if(n >= 763500000){
			count = 190874996;start = 763500000;
			}else if(n >= 763000000){
			count = 190749997;start = 763000000;
			}else if(n >= 762500000){
			count = 190624998;start = 762500000;
			}else if(n >= 762000000){
			count = 190499997;start = 762000000;
			}else if(n >= 761500000){
			count = 190374996;start = 761500000;
			}else if(n >= 761000000){
			count = 190249996;start = 761000000;
			}else if(n >= 760500000){
			count = 190124996;start = 760500000;
			}else if(n >= 760000000){
			count = 189999997;start = 760000000;
			}else if(n >= 759500000){
			count = 189874996;start = 759500000;
			}else if(n >= 759000000){
			count = 189749997;start = 759000000;
			}else if(n >= 758500000){
			count = 189624996;start = 758500000;
			}else if(n >= 758000000){
			count = 189499997;start = 758000000;
			}else if(n >= 757500000){
			count = 189374997;start = 757500000;
			}else if(n >= 757000000){
			count = 189249996;start = 757000000;
			}else if(n >= 756500000){
			count = 189124997;start = 756500000;
			}else if(n >= 756000000){
			count = 188999997;start = 756000000;
			}else if(n >= 755500000){
			count = 188874997;start = 755500000;
			}else if(n >= 755000000){
			count = 188749997;start = 755000000;
			}else if(n >= 754500000){
			count = 188624997;start = 754500000;
			}else if(n >= 754000000){
			count = 188499998;start = 754000000;
			}else if(n >= 753500000){
			count = 188374996;start = 753500000;
			}else if(n >= 753000000){
			count = 188249997;start = 753000000;
			}else if(n >= 752500000){
			count = 188124998;start = 752500000;
			}else if(n >= 752000000){
			count = 187999998;start = 752000000;
			}else if(n >= 751500000){
			count = 187874996;start = 751500000;
			}else if(n >= 751000000){
			count = 187749996;start = 751000000;
			}else if(n >= 750500000){
			count = 187624997;start = 750500000;
			}else if(n >= 750000000){
			count = 187499998;start = 750000000;
			}else if(n >= 749500000){
			count = 187374996;start = 749500000;
			}else if(n >= 749000000){
			count = 187249997;start = 749000000;
			}else if(n >= 748500000){
			count = 187124997;start = 748500000;
			}else if(n >= 748000000){
			count = 186999996;start = 748000000;
			}else if(n >= 747500000){
			count = 186874997;start = 747500000;
			}else if(n >= 747000000){
			count = 186749997;start = 747000000;
			}else if(n >= 746500000){
			count = 186624998;start = 746500000;
			}else if(n >= 746000000){
			count = 186499996;start = 746000000;
			}else if(n >= 745500000){
			count = 186374997;start = 745500000;
			}else if(n >= 745000000){
			count = 186249998;start = 745000000;
			}else if(n >= 744500000){
			count = 186124997;start = 744500000;
			}else if(n >= 744000000){
			count = 185999997;start = 744000000;
			}else if(n >= 743500000){
			count = 185874997;start = 743500000;
			}else if(n >= 743000000){
			count = 185749998;start = 743000000;
			}else if(n >= 742500000){
			count = 185624998;start = 742500000;
			}else if(n >= 742000000){
			count = 185499996;start = 742000000;
			}else if(n >= 741500000){
			count = 185374997;start = 741500000;
			}else if(n >= 741000000){
			count = 185249996;start = 741000000;
			}else if(n >= 740500000){
			count = 185124997;start = 740500000;
			}else if(n >= 740000000){
			count = 184999997;start = 740000000;
			}else if(n >= 739500000){
			count = 184874997;start = 739500000;
			}else if(n >= 739000000){
			count = 184749997;start = 739000000;
			}else if(n >= 738500000){
			count = 184624997;start = 738500000;
			}else if(n >= 738000000){
			count = 184499997;start = 738000000;
			}else if(n >= 737500000){
			count = 184374998;start = 737500000;
			}else if(n >= 737000000){
			count = 184249997;start = 737000000;
			}else if(n >= 736500000){
			count = 184124998;start = 736500000;
			}else if(n >= 736000000){
			count = 183999997;start = 736000000;
			}else if(n >= 735500000){
			count = 183874997;start = 735500000;
			}else if(n >= 735000000){
			count = 183749998;start = 735000000;
			}else if(n >= 734500000){
			count = 183624998;start = 734500000;
			}else if(n >= 734000000){
			count = 183499998;start = 734000000;
			}else if(n >= 733500000){
			count = 183374997;start = 733500000;
			}else if(n >= 733000000){
			count = 183249998;start = 733000000;
			}else if(n >= 732500000){
			count = 183124999;start = 732500000;
			}else if(n >= 732000000){
			count = 182999994;start = 732000000;
			}else if(n >= 731500000){
			count = 182874995;start = 731500000;
			}else if(n >= 731000000){
			count = 182749995;start = 731000000;
			}else if(n >= 730500000){
			count = 182624996;start = 730500000;
			}else if(n >= 730000000){
			count = 182499995;start = 730000000;
			}else if(n >= 729500000){
			count = 182374995;start = 729500000;
			}else if(n >= 729000000){
			count = 182249996;start = 729000000;
			}else if(n >= 728500000){
			count = 182124994;start = 728500000;
			}else if(n >= 728000000){
			count = 181999995;start = 728000000;
			}else if(n >= 727500000){
			count = 181874996;start = 727500000;
			}else if(n >= 727000000){
			count = 181749996;start = 727000000;
			}else if(n >= 726500000){
			count = 181624995;start = 726500000;
			}else if(n >= 726000000){
			count = 181499995;start = 726000000;
			}else if(n >= 725500000){
			count = 181374996;start = 725500000;
			}else if(n >= 725000000){
			count = 181249997;start = 725000000;
			}else if(n >= 724500000){
			count = 181124995;start = 724500000;
			}else if(n >= 724000000){
			count = 180999996;start = 724000000;
			}else if(n >= 723500000){
			count = 180874996;start = 723500000;
			}else if(n >= 723000000){
			count = 180749996;start = 723000000;
			}else if(n >= 722500000){
			count = 180624995;start = 722500000;
			}else if(n >= 722000000){
			count = 180499995;start = 722000000;
			}else if(n >= 721500000){
			count = 180374996;start = 721500000;
			}else if(n >= 721000000){
			count = 180249995;start = 721000000;
			}else if(n >= 720500000){
			count = 180124995;start = 720500000;
			}else if(n >= 720000000){
			count = 179999996;start = 720000000;
			}else if(n >= 719500000){
			count = 179874995;start = 719500000;
			}else if(n >= 719000000){
			count = 179749996;start = 719000000;
			}else if(n >= 718500000){
			count = 179624995;start = 718500000;
			}else if(n >= 718000000){
			count = 179499996;start = 718000000;
			}else if(n >= 717500000){
			count = 179374996;start = 717500000;
			}else if(n >= 717000000){
			count = 179249996;start = 717000000;
			}else if(n >= 716500000){
			count = 179124996;start = 716500000;
			}else if(n >= 716000000){
			count = 178999995;start = 716000000;
			}else if(n >= 715500000){
			count = 178874996;start = 715500000;
			}else if(n >= 715000000){
			count = 178749997;start = 715000000;
			}else if(n >= 714500000){
			count = 178624996;start = 714500000;
			}else if(n >= 714000000){
			count = 178499996;start = 714000000;
			}else if(n >= 713500000){
			count = 178374996;start = 713500000;
			}else if(n >= 713000000){
			count = 178249997;start = 713000000;
			}else if(n >= 712500000){
			count = 178124996;start = 712500000;
			}else if(n >= 712000000){
			count = 177999995;start = 712000000;
			}else if(n >= 711500000){
			count = 177874996;start = 711500000;
			}else if(n >= 711000000){
			count = 177749996;start = 711000000;
			}else if(n >= 710500000){
			count = 177624995;start = 710500000;
			}else if(n >= 710000000){
			count = 177499996;start = 710000000;
			}else if(n >= 709500000){
			count = 177374996;start = 709500000;
			}else if(n >= 709000000){
			count = 177249997;start = 709000000;
			}else if(n >= 708500000){
			count = 177124995;start = 708500000;
			}else if(n >= 708000000){
			count = 176999996;start = 708000000;
			}else if(n >= 707500000){
			count = 176874997;start = 707500000;
			}else if(n >= 707000000){
			count = 176749995;start = 707000000;
			}else if(n >= 706500000){
			count = 176624996;start = 706500000;
			}else if(n >= 706000000){
			count = 176499996;start = 706000000;
			}else if(n >= 705500000){
			count = 176374997;start = 705500000;
			}else if(n >= 705000000){
			count = 176249996;start = 705000000;
			}else if(n >= 704500000){
			count = 176124996;start = 704500000;
			}else if(n >= 704000000){
			count = 175999997;start = 704000000;
			}else if(n >= 703500000){
			count = 175874996;start = 703500000;
			}else if(n >= 703000000){
			count = 175749995;start = 703000000;
			}else if(n >= 702500000){
			count = 175624996;start = 702500000;
			}else if(n >= 702000000){
			count = 175499996;start = 702000000;
			}else if(n >= 701500000){
			count = 175374996;start = 701500000;
			}else if(n >= 701000000){
			count = 175249995;start = 701000000;
			}else if(n >= 700500000){
			count = 175124996;start = 700500000;
			}else if(n >= 700000000){
			count = 174999997;start = 700000000;
			}else if(n >= 699500000){
			count = 174874996;start = 699500000;
			}else if(n >= 699000000){
			count = 174749996;start = 699000000;
			}else if(n >= 698500000){
			count = 174624996;start = 698500000;
			}else if(n >= 698000000){
			count = 174499996;start = 698000000;
			}else if(n >= 697500000){
			count = 174374997;start = 697500000;
			}else if(n >= 697000000){
			count = 174249996;start = 697000000;
			}else if(n >= 696500000){
			count = 174124997;start = 696500000;
			}else if(n >= 696000000){
			count = 173999996;start = 696000000;
			}else if(n >= 695500000){
			count = 173874997;start = 695500000;
			}else if(n >= 695000000){
			count = 173749997;start = 695000000;
			}else if(n >= 694500000){
			count = 173624996;start = 694500000;
			}else if(n >= 694000000){
			count = 173499997;start = 694000000;
			}else if(n >= 693500000){
			count = 173374997;start = 693500000;
			}else if(n >= 693000000){
			count = 173249996;start = 693000000;
			}else if(n >= 692500000){
			count = 173124996;start = 692500000;
			}else if(n >= 692000000){
			count = 172999996;start = 692000000;
			}else if(n >= 691500000){
			count = 172874997;start = 691500000;
			}else if(n >= 691000000){
			count = 172749995;start = 691000000;
			}else if(n >= 690500000){
			count = 172624996;start = 690500000;
			}else if(n >= 690000000){
			count = 172499997;start = 690000000;
			}else if(n >= 689500000){
			count = 172374997;start = 689500000;
			}else if(n >= 689000000){
			count = 172249996;start = 689000000;
			}else if(n >= 688500000){
			count = 172124996;start = 688500000;
			}else if(n >= 688000000){
			count = 171999997;start = 688000000;
			}else if(n >= 687500000){
			count = 171874998;start = 687500000;
			}else if(n >= 687000000){
			count = 171749996;start = 687000000;
			}else if(n >= 686500000){
			count = 171624997;start = 686500000;
			}else if(n >= 686000000){
			count = 171499997;start = 686000000;
			}else if(n >= 685500000){
			count = 171374996;start = 685500000;
			}else if(n >= 685000000){
			count = 171249997;start = 685000000;
			}else if(n >= 684500000){
			count = 171124997;start = 684500000;
			}else if(n >= 684000000){
			count = 170999998;start = 684000000;
			}else if(n >= 683500000){
			count = 170874994;start = 683500000;
			}else if(n >= 683000000){
			count = 170749995;start = 683000000;
			}else if(n >= 682500000){
			count = 170624996;start = 682500000;
			}else if(n >= 682000000){
			count = 170499995;start = 682000000;
			}else if(n >= 681500000){
			count = 170374995;start = 681500000;
			}else if(n >= 681000000){
			count = 170249995;start = 681000000;
			}else if(n >= 680500000){
			count = 170124996;start = 680500000;
			}else if(n >= 680000000){
			count = 169999996;start = 680000000;
			}else if(n >= 679500000){
			count = 169874995;start = 679500000;
			}else if(n >= 679000000){
			count = 169749996;start = 679000000;
			}else if(n >= 678500000){
			count = 169624995;start = 678500000;
			}else if(n >= 678000000){
			count = 169499996;start = 678000000;
			}else if(n >= 677500000){
			count = 169374996;start = 677500000;
			}else if(n >= 677000000){
			count = 169249996;start = 677000000;
			}else if(n >= 676500000){
			count = 169124996;start = 676500000;
			}else if(n >= 676000000){
			count = 168999996;start = 676000000;
			}else if(n >= 675500000){
			count = 168874996;start = 675500000;
			}else if(n >= 675000000){
			count = 168749997;start = 675000000;
			}else if(n >= 674500000){
			count = 168624996;start = 674500000;
			}else if(n >= 674000000){
			count = 168499997;start = 674000000;
			}else if(n >= 673500000){
			count = 168374995;start = 673500000;
			}else if(n >= 673000000){
			count = 168249995;start = 673000000;
			}else if(n >= 672500000){
			count = 168124996;start = 672500000;
			}else if(n >= 672000000){
			count = 167999996;start = 672000000;
			}else if(n >= 671500000){
			count = 167874996;start = 671500000;
			}else if(n >= 671000000){
			count = 167749995;start = 671000000;
			}else if(n >= 670500000){
			count = 167624996;start = 670500000;
			}else if(n >= 670000000){
			count = 167499997;start = 670000000;
			}else if(n >= 669500000){
			count = 167374995;start = 669500000;
			}else if(n >= 669000000){
			count = 167249996;start = 669000000;
			}else if(n >= 668500000){
			count = 167124996;start = 668500000;
			}else if(n >= 668000000){
			count = 166999997;start = 668000000;
			}else if(n >= 667500000){
			count = 166874996;start = 667500000;
			}else if(n >= 667000000){
			count = 166749996;start = 667000000;
			}else if(n >= 666500000){
			count = 166624997;start = 666500000;
			}else if(n >= 666000000){
			count = 166499995;start = 666000000;
			}else if(n >= 665500000){
			count = 166374996;start = 665500000;
			}else if(n >= 665000000){
			count = 166249997;start = 665000000;
			}else if(n >= 664500000){
			count = 166124997;start = 664500000;
			}else if(n >= 664000000){
			count = 165999995;start = 664000000;
			}else if(n >= 663500000){
			count = 165874995;start = 663500000;
			}else if(n >= 663000000){
			count = 165749996;start = 663000000;
			}else if(n >= 662500000){
			count = 165624997;start = 662500000;
			}else if(n >= 662000000){
			count = 165499995;start = 662000000;
			}else if(n >= 661500000){
			count = 165374996;start = 661500000;
			}else if(n >= 661000000){
			count = 165249996;start = 661000000;
			}else if(n >= 660500000){
			count = 165124996;start = 660500000;
			}else if(n >= 660000000){
			count = 164999996;start = 660000000;
			}else if(n >= 659500000){
			count = 164874996;start = 659500000;
			}else if(n >= 659000000){
			count = 164749997;start = 659000000;
			}else if(n >= 658500000){
			count = 164624996;start = 658500000;
			}else if(n >= 658000000){
			count = 164499996;start = 658000000;
			}else if(n >= 657500000){
			count = 164374997;start = 657500000;
			}else if(n >= 657000000){
			count = 164249996;start = 657000000;
			}else if(n >= 656500000){
			count = 164124997;start = 656500000;
			}else if(n >= 656000000){
			count = 163999996;start = 656000000;
			}else if(n >= 655500000){
			count = 163874997;start = 655500000;
			}else if(n >= 655000000){
			count = 163749997;start = 655000000;
			}else if(n >= 654500000){
			count = 163624997;start = 654500000;
			}else if(n >= 654000000){
			count = 163499996;start = 654000000;
			}else if(n >= 653500000){
			count = 163374995;start = 653500000;
			}else if(n >= 653000000){
			count = 163249996;start = 653000000;
			}else if(n >= 652500000){
			count = 163124997;start = 652500000;
			}else if(n >= 652000000){
			count = 162999996;start = 652000000;
			}else if(n >= 651500000){
			count = 162874996;start = 651500000;
			}else if(n >= 651000000){
			count = 162749996;start = 651000000;
			}else if(n >= 650500000){
			count = 162624997;start = 650500000;
			}else if(n >= 650000000){
			count = 162499997;start = 650000000;
			}else if(n >= 649500000){
			count = 162374996;start = 649500000;
			}else if(n >= 649000000){
			count = 162249997;start = 649000000;
			}else if(n >= 648500000){
			count = 162124997;start = 648500000;
			}else if(n >= 648000000){
			count = 161999996;start = 648000000;
			}else if(n >= 647500000){
			count = 161874997;start = 647500000;
			}else if(n >= 647000000){
			count = 161749997;start = 647000000;
			}else if(n >= 646500000){
			count = 161624998;start = 646500000;
			}else if(n >= 646000000){
			count = 161499996;start = 646000000;
			}else if(n >= 645500000){
			count = 161374997;start = 645500000;
			}else if(n >= 645000000){
			count = 161249998;start = 645000000;
			}else if(n >= 644500000){
			count = 161124995;start = 644500000;
			}else if(n >= 644000000){
			count = 160999996;start = 644000000;
			}else if(n >= 643500000){
			count = 160874996;start = 643500000;
			}else if(n >= 643000000){
			count = 160749997;start = 643000000;
			}else if(n >= 642500000){
			count = 160624996;start = 642500000;
			}else if(n >= 642000000){
			count = 160499996;start = 642000000;
			}else if(n >= 641500000){
			count = 160374997;start = 641500000;
			}else if(n >= 641000000){
			count = 160249996;start = 641000000;
			}else if(n >= 640500000){
			count = 160124996;start = 640500000;
			}else if(n >= 640000000){
			count = 159999997;start = 640000000;
			}else if(n >= 639500000){
			count = 159874997;start = 639500000;
			}else if(n >= 639000000){
			count = 159749997;start = 639000000;
			}else if(n >= 638500000){
			count = 159624996;start = 638500000;
			}else if(n >= 638000000){
			count = 159499997;start = 638000000;
			}else if(n >= 637500000){
			count = 159374998;start = 637500000;
			}else if(n >= 637000000){
			count = 159249997;start = 637000000;
			}else if(n >= 636500000){
			count = 159124997;start = 636500000;
			}else if(n >= 636000000){
			count = 158999997;start = 636000000;
			}else if(n >= 635500000){
			count = 158874997;start = 635500000;
			}else if(n >= 635000000){
			count = 158749998;start = 635000000;
			}else if(n >= 634500000){
			count = 158624995;start = 634500000;
			}else if(n >= 634000000){
			count = 158499996;start = 634000000;
			}else if(n >= 633500000){
			count = 158374995;start = 633500000;
			}else if(n >= 633000000){
			count = 158249996;start = 633000000;
			}else if(n >= 632500000){
			count = 158124996;start = 632500000;
			}else if(n >= 632000000){
			count = 157999995;start = 632000000;
			}else if(n >= 631500000){
			count = 157874996;start = 631500000;
			}else if(n >= 631000000){
			count = 157749996;start = 631000000;
			}else if(n >= 630500000){
			count = 157624996;start = 630500000;
			}else if(n >= 630000000){
			count = 157499996;start = 630000000;
			}else if(n >= 629500000){
			count = 157374996;start = 629500000;
			}else if(n >= 629000000){
			count = 157249997;start = 629000000;
			}else if(n >= 628500000){
			count = 157124995;start = 628500000;
			}else if(n >= 628000000){
			count = 156999996;start = 628000000;
			}else if(n >= 627500000){
			count = 156874997;start = 627500000;
			}else if(n >= 627000000){
			count = 156749997;start = 627000000;
			}else if(n >= 626500000){
			count = 156624996;start = 626500000;
			}else if(n >= 626000000){
			count = 156499996;start = 626000000;
			}else if(n >= 625500000){
			count = 156374997;start = 625500000;
			}else if(n >= 625000000){
			count = 156249998;start = 625000000;
			}else if(n >= 624500000){
			count = 156124995;start = 624500000;
			}else if(n >= 624000000){
			count = 155999996;start = 624000000;
			}else if(n >= 623500000){
			count = 155874996;start = 623500000;
			}else if(n >= 623000000){
			count = 155749995;start = 623000000;
			}else if(n >= 622500000){
			count = 155624996;start = 622500000;
			}else if(n >= 622000000){
			count = 155499996;start = 622000000;
			}else if(n >= 621500000){
			count = 155374997;start = 621500000;
			}else if(n >= 621000000){
			count = 155249995;start = 621000000;
			}else if(n >= 620500000){
			count = 155124996;start = 620500000;
			}else if(n >= 620000000){
			count = 154999997;start = 620000000;
			}else if(n >= 619500000){
			count = 154874996;start = 619500000;
			}else if(n >= 619000000){
			count = 154749996;start = 619000000;
			}else if(n >= 618500000){
			count = 154624996;start = 618500000;
			}else if(n >= 618000000){
			count = 154499997;start = 618000000;
			}else if(n >= 617500000){
			count = 154374997;start = 617500000;
			}else if(n >= 617000000){
			count = 154249996;start = 617000000;
			}else if(n >= 616500000){
			count = 154124997;start = 616500000;
			}else if(n >= 616000000){
			count = 153999996;start = 616000000;
			}else if(n >= 615500000){
			count = 153874997;start = 615500000;
			}else if(n >= 615000000){
			count = 153749996;start = 615000000;
			}else if(n >= 614500000){
			count = 153624996;start = 614500000;
			}else if(n >= 614000000){
			count = 153499996;start = 614000000;
			}else if(n >= 613500000){
			count = 153374996;start = 613500000;
			}else if(n >= 613000000){
			count = 153249996;start = 613000000;
			}else if(n >= 612500000){
			count = 153124997;start = 612500000;
			}else if(n >= 612000000){
			count = 152999996;start = 612000000;
			}else if(n >= 611500000){
			count = 152874997;start = 611500000;
			}else if(n >= 611000000){
			count = 152749996;start = 611000000;
			}else if(n >= 610500000){
			count = 152624996;start = 610500000;
			}else if(n >= 610000000){
			count = 152499997;start = 610000000;
			}else if(n >= 609500000){
			count = 152374997;start = 609500000;
			}else if(n >= 609000000){
			count = 152249997;start = 609000000;
			}else if(n >= 608500000){
			count = 152124996;start = 608500000;
			}else if(n >= 608000000){
			count = 151999997;start = 608000000;
			}else if(n >= 607500000){
			count = 151874998;start = 607500000;
			}else if(n >= 607000000){
			count = 151749996;start = 607000000;
			}else if(n >= 606500000){
			count = 151624997;start = 606500000;
			}else if(n >= 606000000){
			count = 151499997;start = 606000000;
			}else if(n >= 605500000){
			count = 151374998;start = 605500000;
			}else if(n >= 605000000){
			count = 151249996;start = 605000000;
			}else if(n >= 604500000){
			count = 151124996;start = 604500000;
			}else if(n >= 604000000){
			count = 150999997;start = 604000000;
			}else if(n >= 603500000){
			count = 150874995;start = 603500000;
			}else if(n >= 603000000){
			count = 150749996;start = 603000000;
			}else if(n >= 602500000){
			count = 150624997;start = 602500000;
			}else if(n >= 602000000){
			count = 150499997;start = 602000000;
			}else if(n >= 601500000){
			count = 150374996;start = 601500000;
			}else if(n >= 601000000){
			count = 150249996;start = 601000000;
			}else if(n >= 600500000){
			count = 150124997;start = 600500000;
			}else if(n >= 600000000){
			count = 149999998;start = 600000000;
			}else if(n >= 599500000){
			count = 149874996;start = 599500000;
			}else if(n >= 599000000){
			count = 149749997;start = 599000000;
			}else if(n >= 598500000){
			count = 149624997;start = 598500000;
			}else if(n >= 598000000){
			count = 149499997;start = 598000000;
			}else if(n >= 597500000){
			count = 149374997;start = 597500000;
			}else if(n >= 597000000){
			count = 149249997;start = 597000000;
			}else if(n >= 596500000){
			count = 149124998;start = 596500000;
			}else if(n >= 596000000){
			count = 148999997;start = 596000000;
			}else if(n >= 595500000){
			count = 148874996;start = 595500000;
			}else if(n >= 595000000){
			count = 148749997;start = 595000000;
			}else if(n >= 594500000){
			count = 148624996;start = 594500000;
			}else if(n >= 594000000){
			count = 148499997;start = 594000000;
			}else if(n >= 593500000){
			count = 148374996;start = 593500000;
			}else if(n >= 593000000){
			count = 148249997;start = 593000000;
			}else if(n >= 592500000){
			count = 148124997;start = 592500000;
			}else if(n >= 592000000){
			count = 147999997;start = 592000000;
			}else if(n >= 591500000){
			count = 147874997;start = 591500000;
			}else if(n >= 591000000){
			count = 147749996;start = 591000000;
			}else if(n >= 590500000){
			count = 147624997;start = 590500000;
			}else if(n >= 590000000){
			count = 147499998;start = 590000000;
			}else if(n >= 589500000){
			count = 147374997;start = 589500000;
			}else if(n >= 589000000){
			count = 147249997;start = 589000000;
			}else if(n >= 588500000){
			count = 147124997;start = 588500000;
			}else if(n >= 588000000){
			count = 146999998;start = 588000000;
			}else if(n >= 587500000){
			count = 146874998;start = 587500000;
			}else if(n >= 587000000){
			count = 146749997;start = 587000000;
			}else if(n >= 586500000){
			count = 146624998;start = 586500000;
			}else if(n >= 586000000){
			count = 146499998;start = 586000000;
			}else if(n >= 585500000){
			count = 146374995;start = 585500000;
			}else if(n >= 585000000){
			count = 146249996;start = 585000000;
			}else if(n >= 584500000){
			count = 146124996;start = 584500000;
			}else if(n >= 584000000){
			count = 145999997;start = 584000000;
			}else if(n >= 583500000){
			count = 145874995;start = 583500000;
			}else if(n >= 583000000){
			count = 145749996;start = 583000000;
			}else if(n >= 582500000){
			count = 145624997;start = 582500000;
			}else if(n >= 582000000){
			count = 145499995;start = 582000000;
			}else if(n >= 581500000){
			count = 145374996;start = 581500000;
			}else if(n >= 581000000){
			count = 145249996;start = 581000000;
			}else if(n >= 580500000){
			count = 145124997;start = 580500000;
			}else if(n >= 580000000){
			count = 144999996;start = 580000000;
			}else if(n >= 579500000){
			count = 144874996;start = 579500000;
			}else if(n >= 579000000){
			count = 144749997;start = 579000000;
			}else if(n >= 578500000){
			count = 144624996;start = 578500000;
			}else if(n >= 578000000){
			count = 144499996;start = 578000000;
			}else if(n >= 577500000){
			count = 144374997;start = 577500000;
			}else if(n >= 577000000){
			count = 144249997;start = 577000000;
			}else if(n >= 576500000){
			count = 144124997;start = 576500000;
			}else if(n >= 576000000){
			count = 143999995;start = 576000000;
			}else if(n >= 575500000){
			count = 143874996;start = 575500000;
			}else if(n >= 575000000){
			count = 143749997;start = 575000000;
			}else if(n >= 574500000){
			count = 143624996;start = 574500000;
			}else if(n >= 574000000){
			count = 143499996;start = 574000000;
			}else if(n >= 573500000){
			count = 143374996;start = 573500000;
			}else if(n >= 573000000){
			count = 143249996;start = 573000000;
			}else if(n >= 572500000){
			count = 143124997;start = 572500000;
			}else if(n >= 572000000){
			count = 142999996;start = 572000000;
			}else if(n >= 571500000){
			count = 142874997;start = 571500000;
			}else if(n >= 571000000){
			count = 142749996;start = 571000000;
			}else if(n >= 570500000){
			count = 142624997;start = 570500000;
			}else if(n >= 570000000){
			count = 142499997;start = 570000000;
			}else if(n >= 569500000){
			count = 142374996;start = 569500000;
			}else if(n >= 569000000){
			count = 142249997;start = 569000000;
			}else if(n >= 568500000){
			count = 142124997;start = 568500000;
			}else if(n >= 568000000){
			count = 141999997;start = 568000000;
			}else if(n >= 567500000){
			count = 141874997;start = 567500000;
			}else if(n >= 567000000){
			count = 141749997;start = 567000000;
			}else if(n >= 566500000){
			count = 141624998;start = 566500000;
			}else if(n >= 566000000){
			count = 141499995;start = 566000000;
			}else if(n >= 565500000){
			count = 141374996;start = 565500000;
			}else if(n >= 565000000){
			count = 141249997;start = 565000000;
			}else if(n >= 564500000){
			count = 141124997;start = 564500000;
			}else if(n >= 564000000){
			count = 140999996;start = 564000000;
			}else if(n >= 563500000){
			count = 140874996;start = 563500000;
			}else if(n >= 563000000){
			count = 140749997;start = 563000000;
			}else if(n >= 562500000){
			count = 140624998;start = 562500000;
			}else if(n >= 562000000){
			count = 140499996;start = 562000000;
			}else if(n >= 561500000){
			count = 140374997;start = 561500000;
			}else if(n >= 561000000){
			count = 140249997;start = 561000000;
			}else if(n >= 560500000){
			count = 140124996;start = 560500000;
			}else if(n >= 560000000){
			count = 139999997;start = 560000000;
			}else if(n >= 559500000){
			count = 139874997;start = 559500000;
			}else if(n >= 559000000){
			count = 139749998;start = 559000000;
			}else if(n >= 558500000){
			count = 139624996;start = 558500000;
			}else if(n >= 558000000){
			count = 139499997;start = 558000000;
			}else if(n >= 557500000){
			count = 139374998;start = 557500000;
			}else if(n >= 557000000){
			count = 139249997;start = 557000000;
			}else if(n >= 556500000){
			count = 139124996;start = 556500000;
			}else if(n >= 556000000){
			count = 138999996;start = 556000000;
			}else if(n >= 555500000){
			count = 138874997;start = 555500000;
			}else if(n >= 555000000){
			count = 138749997;start = 555000000;
			}else if(n >= 554500000){
			count = 138624996;start = 554500000;
			}else if(n >= 554000000){
			count = 138499997;start = 554000000;
			}else if(n >= 553500000){
			count = 138374996;start = 553500000;
			}else if(n >= 553000000){
			count = 138249997;start = 553000000;
			}else if(n >= 552500000){
			count = 138124997;start = 552500000;
			}else if(n >= 552000000){
			count = 137999997;start = 552000000;
			}else if(n >= 551500000){
			count = 137874997;start = 551500000;
			}else if(n >= 551000000){
			count = 137749997;start = 551000000;
			}else if(n >= 550500000){
			count = 137624997;start = 550500000;
			}else if(n >= 550000000){
			count = 137499998;start = 550000000;
			}else if(n >= 549500000){
			count = 137374997;start = 549500000;
			}else if(n >= 549000000){
			count = 137249998;start = 549000000;
			}else if(n >= 548500000){
			count = 137124997;start = 548500000;
			}else if(n >= 548000000){
			count = 136999997;start = 548000000;
			}else if(n >= 547500000){
			count = 136874998;start = 547500000;
			}else if(n >= 547000000){
			count = 136749998;start = 547000000;
			}else if(n >= 546500000){
			count = 136624997;start = 546500000;
			}else if(n >= 546000000){
			count = 136499996;start = 546000000;
			}else if(n >= 545500000){
			count = 136374997;start = 545500000;
			}else if(n >= 545000000){
			count = 136249998;start = 545000000;
			}else if(n >= 544500000){
			count = 136124996;start = 544500000;
			}else if(n >= 544000000){
			count = 135999997;start = 544000000;
			}else if(n >= 543500000){
			count = 135874997;start = 543500000;
			}else if(n >= 543000000){
			count = 135749998;start = 543000000;
			}else if(n >= 542500000){
			count = 135624997;start = 542500000;
			}else if(n >= 542000000){
			count = 135499997;start = 542000000;
			}else if(n >= 541500000){
			count = 135374998;start = 541500000;
			}else if(n >= 541000000){
			count = 135249996;start = 541000000;
			}else if(n >= 540500000){
			count = 135124997;start = 540500000;
			}else if(n >= 540000000){
			count = 134999998;start = 540000000;
			}else if(n >= 539500000){
			count = 134874998;start = 539500000;
			}else if(n >= 539000000){
			count = 134749997;start = 539000000;
			}else if(n >= 538500000){
			count = 134624997;start = 538500000;
			}else if(n >= 538000000){
			count = 134499998;start = 538000000;
			}else if(n >= 537500000){
			count = 134374999;start = 537500000;
			}else if(n >= 537000000){
			count = 134249995;start = 537000000;
			}else if(n >= 536500000){
			count = 134124996;start = 536500000;
			}else if(n >= 536000000){
			count = 133999996;start = 536000000;
			}else if(n >= 535500000){
			count = 133874996;start = 535500000;
			}else if(n >= 535000000){
			count = 133749996;start = 535000000;
			}else if(n >= 534500000){
			count = 133624996;start = 534500000;
			}else if(n >= 534000000){
			count = 133499997;start = 534000000;
			}else if(n >= 533500000){
			count = 133374996;start = 533500000;
			}else if(n >= 533000000){
			count = 133249996;start = 533000000;
			}else if(n >= 532500000){
			count = 133124997;start = 532500000;
			}else if(n >= 532000000){
			count = 132999996;start = 532000000;
			}else if(n >= 531500000){
			count = 132874997;start = 531500000;
			}else if(n >= 531000000){
			count = 132749996;start = 531000000;
			}else if(n >= 530500000){
			count = 132624997;start = 530500000;
			}else if(n >= 530000000){
			count = 132499997;start = 530000000;
			}else if(n >= 529500000){
			count = 132374997;start = 529500000;
			}else if(n >= 529000000){
			count = 132249997;start = 529000000;
			}else if(n >= 528500000){
			count = 132124996;start = 528500000;
			}else if(n >= 528000000){
			count = 131999997;start = 528000000;
			}else if(n >= 527500000){
			count = 131874998;start = 527500000;
			}else if(n >= 527000000){
			count = 131749996;start = 527000000;
			}else if(n >= 526500000){
			count = 131624996;start = 526500000;
			}else if(n >= 526000000){
			count = 131499996;start = 526000000;
			}else if(n >= 525500000){
			count = 131374997;start = 525500000;
			}else if(n >= 525000000){
			count = 131249997;start = 525000000;
			}else if(n >= 524500000){
			count = 131124996;start = 524500000;
			}else if(n >= 524000000){
			count = 130999997;start = 524000000;
			}else if(n >= 523500000){
			count = 130874997;start = 523500000;
			}else if(n >= 523000000){
			count = 130749996;start = 523000000;
			}else if(n >= 522500000){
			count = 130624997;start = 522500000;
			}else if(n >= 522000000){
			count = 130499997;start = 522000000;
			}else if(n >= 521500000){
			count = 130374998;start = 521500000;
			}else if(n >= 521000000){
			count = 130249996;start = 521000000;
			}else if(n >= 520500000){
			count = 130124997;start = 520500000;
			}else if(n >= 520000000){
			count = 129999998;start = 520000000;
			}else if(n >= 519500000){
			count = 129874996;start = 519500000;
			}else if(n >= 519000000){
			count = 129749997;start = 519000000;
			}else if(n >= 518500000){
			count = 129624997;start = 518500000;
			}else if(n >= 518000000){
			count = 129499998;start = 518000000;
			}else if(n >= 517500000){
			count = 129374996;start = 517500000;
			}else if(n >= 517000000){
			count = 129249996;start = 517000000;
			}else if(n >= 516500000){
			count = 129124997;start = 516500000;
			}else if(n >= 516000000){
			count = 128999996;start = 516000000;
			}else if(n >= 515500000){
			count = 128874996;start = 515500000;
			}else if(n >= 515000000){
			count = 128749997;start = 515000000;
			}else if(n >= 514500000){
			count = 128624997;start = 514500000;
			}else if(n >= 514000000){
			count = 128499997;start = 514000000;
			}else if(n >= 513500000){
			count = 128374996;start = 513500000;
			}else if(n >= 513000000){
			count = 128249997;start = 513000000;
			}else if(n >= 512500000){
			count = 128124998;start = 512500000;
			}else if(n >= 512000000){
			count = 127999997;start = 512000000;
			}else if(n >= 511500000){
			count = 127874997;start = 511500000;
			}else if(n >= 511000000){
			count = 127749997;start = 511000000;
			}else if(n >= 510500000){
			count = 127624997;start = 510500000;
			}else if(n >= 510000000){
			count = 127499998;start = 510000000;
			}else if(n >= 509500000){
			count = 127374997;start = 509500000;
			}else if(n >= 509000000){
			count = 127249998;start = 509000000;
			}else if(n >= 508500000){
			count = 127124997;start = 508500000;
			}else if(n >= 508000000){
			count = 126999998;start = 508000000;
			}else if(n >= 507500000){
			count = 126874997;start = 507500000;
			}else if(n >= 507000000){
			count = 126749996;start = 507000000;
			}else if(n >= 506500000){
			count = 126624997;start = 506500000;
			}else if(n >= 506000000){
			count = 126499997;start = 506000000;
			}else if(n >= 505500000){
			count = 126374997;start = 505500000;
			}else if(n >= 505000000){
			count = 126249997;start = 505000000;
			}else if(n >= 504500000){
			count = 126124997;start = 504500000;
			}else if(n >= 504000000){
			count = 125999998;start = 504000000;
			}else if(n >= 503500000){
			count = 125874996;start = 503500000;
			}else if(n >= 503000000){
			count = 125749997;start = 503000000;
			}else if(n >= 502500000){
			count = 125624998;start = 502500000;
			}else if(n >= 502000000){
			count = 125499998;start = 502000000;
			}else if(n >= 501500000){
			count = 125374997;start = 501500000;
			}else if(n >= 501000000){
			count = 125249997;start = 501000000;
			}else if(n >= 500500000){
			count = 125124998;start = 500500000;
			}else if(n >= 500000000){
			count = 124999999;start = 500000000;
			}else if(n >= 499500000){
			count = 124874997;start = 499500000;
			}else if(n >= 499000000){
			count = 124749998;start = 499000000;
			}else if(n >= 498500000){
			count = 124624998;start = 498500000;
			}else if(n >= 498000000){
			count = 124499996;start = 498000000;
			}else if(n >= 497500000){
			count = 124374997;start = 497500000;
			}else if(n >= 497000000){
			count = 124249997;start = 497000000;
			}else if(n >= 496500000){
			count = 124124998;start = 496500000;
			}else if(n >= 496000000){
			count = 123999996;start = 496000000;
			}else if(n >= 495500000){
			count = 123874997;start = 495500000;
			}else if(n >= 495000000){
			count = 123749998;start = 495000000;
			}else if(n >= 494500000){
			count = 123624997;start = 494500000;
			}else if(n >= 494000000){
			count = 123499997;start = 494000000;
			}else if(n >= 493500000){
			count = 123374997;start = 493500000;
			}else if(n >= 493000000){
			count = 123249998;start = 493000000;
			}else if(n >= 492500000){
			count = 123124998;start = 492500000;
			}else if(n >= 492000000){
			count = 122999997;start = 492000000;
			}else if(n >= 491500000){
			count = 122874998;start = 491500000;
			}else if(n >= 491000000){
			count = 122749997;start = 491000000;
			}else if(n >= 490500000){
			count = 122624998;start = 490500000;
			}else if(n >= 490000000){
			count = 122499998;start = 490000000;
			}else if(n >= 489500000){
			count = 122374998;start = 489500000;
			}else if(n >= 489000000){
			count = 122249998;start = 489000000;
			}else if(n >= 488500000){
			count = 122124998;start = 488500000;
			}else if(n >= 488000000){
			count = 121999995;start = 488000000;
			}else if(n >= 487500000){
			count = 121874996;start = 487500000;
			}else if(n >= 487000000){
			count = 121749995;start = 487000000;
			}else if(n >= 486500000){
			count = 121624996;start = 486500000;
			}else if(n >= 486000000){
			count = 121499995;start = 486000000;
			}else if(n >= 485500000){
			count = 121374995;start = 485500000;
			}else if(n >= 485000000){
			count = 121249996;start = 485000000;
			}else if(n >= 484500000){
			count = 121124996;start = 484500000;
			}else if(n >= 484000000){
			count = 120999996;start = 484000000;
			}else if(n >= 483500000){
			count = 120874995;start = 483500000;
			}else if(n >= 483000000){
			count = 120749996;start = 483000000;
			}else if(n >= 482500000){
			count = 120624997;start = 482500000;
			}else if(n >= 482000000){
			count = 120499995;start = 482000000;
			}else if(n >= 481500000){
			count = 120374996;start = 481500000;
			}else if(n >= 481000000){
			count = 120249996;start = 481000000;
			}else if(n >= 480500000){
			count = 120124997;start = 480500000;
			}else if(n >= 480000000){
			count = 119999996;start = 480000000;
			}else if(n >= 479500000){
			count = 119874996;start = 479500000;
			}else if(n >= 479000000){
			count = 119749997;start = 479000000;
			}else if(n >= 478500000){
			count = 119624994;start = 478500000;
			}else if(n >= 478000000){
			count = 119499995;start = 478000000;
			}else if(n >= 477500000){
			count = 119374996;start = 477500000;
			}else if(n >= 477000000){
			count = 119249996;start = 477000000;
			}else if(n >= 476500000){
			count = 119124995;start = 476500000;
			}else if(n >= 476000000){
			count = 118999995;start = 476000000;
			}else if(n >= 475500000){
			count = 118874996;start = 475500000;
			}else if(n >= 475000000){
			count = 118749997;start = 475000000;
			}else if(n >= 474500000){
			count = 118624995;start = 474500000;
			}else if(n >= 474000000){
			count = 118499996;start = 474000000;
			}else if(n >= 473500000){
			count = 118374996;start = 473500000;
			}else if(n >= 473000000){
			count = 118249996;start = 473000000;
			}else if(n >= 472500000){
			count = 118124996;start = 472500000;
			}else if(n >= 472000000){
			count = 117999996;start = 472000000;
			}else if(n >= 471500000){
			count = 117874997;start = 471500000;
			}else if(n >= 471000000){
			count = 117749996;start = 471000000;
			}else if(n >= 470500000){
			count = 117624996;start = 470500000;
			}else if(n >= 470000000){
			count = 117499997;start = 470000000;
			}else if(n >= 469500000){
			count = 117374996;start = 469500000;
			}else if(n >= 469000000){
			count = 117249997;start = 469000000;
			}else if(n >= 468500000){
			count = 117124995;start = 468500000;
			}else if(n >= 468000000){
			count = 116999996;start = 468000000;
			}else if(n >= 467500000){
			count = 116874996;start = 467500000;
			}else if(n >= 467000000){
			count = 116749996;start = 467000000;
			}else if(n >= 466500000){
			count = 116624996;start = 466500000;
			}else if(n >= 466000000){
			count = 116499995;start = 466000000;
			}else if(n >= 465500000){
			count = 116374996;start = 465500000;
			}else if(n >= 465000000){
			count = 116249997;start = 465000000;
			}else if(n >= 464500000){
			count = 116124996;start = 464500000;
			}else if(n >= 464000000){
			count = 115999996;start = 464000000;
			}else if(n >= 463500000){
			count = 115874996;start = 463500000;
			}else if(n >= 463000000){
			count = 115749997;start = 463000000;
			}else if(n >= 462500000){
			count = 115624997;start = 462500000;
			}else if(n >= 462000000){
			count = 115499996;start = 462000000;
			}else if(n >= 461500000){
			count = 115374997;start = 461500000;
			}else if(n >= 461000000){
			count = 115249997;start = 461000000;
			}else if(n >= 460500000){
			count = 115124996;start = 460500000;
			}else if(n >= 460000000){
			count = 114999997;start = 460000000;
			}else if(n >= 459500000){
			count = 114874997;start = 459500000;
			}else if(n >= 459000000){
			count = 114749998;start = 459000000;
			}else if(n >= 458500000){
			count = 114624995;start = 458500000;
			}else if(n >= 458000000){
			count = 114499996;start = 458000000;
			}else if(n >= 457500000){
			count = 114374997;start = 457500000;
			}else if(n >= 457000000){
			count = 114249995;start = 457000000;
			}else if(n >= 456500000){
			count = 114124996;start = 456500000;
			}else if(n >= 456000000){
			count = 113999996;start = 456000000;
			}else if(n >= 455500000){
			count = 113874997;start = 455500000;
			}else if(n >= 455000000){
			count = 113749996;start = 455000000;
			}else if(n >= 454500000){
			count = 113624996;start = 454500000;
			}else if(n >= 454000000){
			count = 113499997;start = 454000000;
			}else if(n >= 453500000){
			count = 113374996;start = 453500000;
			}else if(n >= 453000000){
			count = 113249996;start = 453000000;
			}else if(n >= 452500000){
			count = 113124997;start = 452500000;
			}else if(n >= 452000000){
			count = 112999997;start = 452000000;
			}else if(n >= 451500000){
			count = 112874997;start = 451500000;
			}else if(n >= 451000000){
			count = 112749996;start = 451000000;
			}else if(n >= 450500000){
			count = 112624997;start = 450500000;
			}else if(n >= 450000000){
			count = 112499998;start = 450000000;
			}else if(n >= 449500000){
			count = 112374997;start = 449500000;
			}else if(n >= 449000000){
			count = 112249996;start = 449000000;
			}else if(n >= 448500000){
			count = 112124996;start = 448500000;
			}else if(n >= 448000000){
			count = 111999996;start = 448000000;
			}else if(n >= 447500000){
			count = 111874997;start = 447500000;
			}else if(n >= 447000000){
			count = 111749996;start = 447000000;
			}else if(n >= 446500000){
			count = 111624997;start = 446500000;
			}else if(n >= 446000000){
			count = 111499996;start = 446000000;
			}else if(n >= 445500000){
			count = 111374997;start = 445500000;
			}else if(n >= 445000000){
			count = 111249997;start = 445000000;
			}else if(n >= 444500000){
			count = 111124996;start = 444500000;
			}else if(n >= 444000000){
			count = 110999997;start = 444000000;
			}else if(n >= 443500000){
			count = 110874997;start = 443500000;
			}else if(n >= 443000000){
			count = 110749997;start = 443000000;
			}else if(n >= 442500000){
			count = 110624997;start = 442500000;
			}else if(n >= 442000000){
			count = 110499997;start = 442000000;
			}else if(n >= 441500000){
			count = 110374998;start = 441500000;
			}else if(n >= 441000000){
			count = 110249996;start = 441000000;
			}else if(n >= 440500000){
			count = 110124997;start = 440500000;
			}else if(n >= 440000000){
			count = 109999998;start = 440000000;
			}else if(n >= 439500000){
			count = 109874998;start = 439500000;
			}else if(n >= 439000000){
			count = 109749995;start = 439000000;
			}else if(n >= 438500000){
			count = 109624995;start = 438500000;
			}else if(n >= 438000000){
			count = 109499996;start = 438000000;
			}else if(n >= 437500000){
			count = 109374997;start = 437500000;
			}else if(n >= 437000000){
			count = 109249995;start = 437000000;
			}else if(n >= 436500000){
			count = 109124996;start = 436500000;
			}else if(n >= 436000000){
			count = 108999996;start = 436000000;
			}else if(n >= 435500000){
			count = 108874995;start = 435500000;
			}else if(n >= 435000000){
			count = 108749996;start = 435000000;
			}else if(n >= 434500000){
			count = 108624996;start = 434500000;
			}else if(n >= 434000000){
			count = 108499997;start = 434000000;
			}else if(n >= 433500000){
			count = 108374995;start = 433500000;
			}else if(n >= 433000000){
			count = 108249996;start = 433000000;
			}else if(n >= 432500000){
			count = 108124997;start = 432500000;
			}else if(n >= 432000000){
			count = 107999996;start = 432000000;
			}else if(n >= 431500000){
			count = 107874996;start = 431500000;
			}else if(n >= 431000000){
			count = 107749996;start = 431000000;
			}else if(n >= 430500000){
			count = 107624997;start = 430500000;
			}else if(n >= 430000000){
			count = 107499997;start = 430000000;
			}else if(n >= 429500000){
			count = 107374995;start = 429500000;
			}else if(n >= 429000000){
			count = 107249996;start = 429000000;
			}else if(n >= 428500000){
			count = 107124995;start = 428500000;
			}else if(n >= 428000000){
			count = 106999996;start = 428000000;
			}else if(n >= 427500000){
			count = 106874996;start = 427500000;
			}else if(n >= 427000000){
			count = 106749996;start = 427000000;
			}else if(n >= 426500000){
			count = 106624996;start = 426500000;
			}else if(n >= 426000000){
			count = 106499996;start = 426000000;
			}else if(n >= 425500000){
			count = 106374996;start = 425500000;
			}else if(n >= 425000000){
			count = 106249997;start = 425000000;
			}else if(n >= 424500000){
			count = 106124996;start = 424500000;
			}else if(n >= 424000000){
			count = 105999997;start = 424000000;
			}else if(n >= 423500000){
			count = 105874996;start = 423500000;
			}else if(n >= 423000000){
			count = 105749996;start = 423000000;
			}else if(n >= 422500000){
			count = 105624997;start = 422500000;
			}else if(n >= 422000000){
			count = 105499997;start = 422000000;
			}else if(n >= 421500000){
			count = 105374997;start = 421500000;
			}else if(n >= 421000000){
			count = 105249996;start = 421000000;
			}else if(n >= 420500000){
			count = 105124997;start = 420500000;
			}else if(n >= 420000000){
			count = 104999998;start = 420000000;
			}else if(n >= 419500000){
			count = 104874995;start = 419500000;
			}else if(n >= 419000000){
			count = 104749996;start = 419000000;
			}else if(n >= 418500000){
			count = 104624996;start = 418500000;
			}else if(n >= 418000000){
			count = 104499997;start = 418000000;
			}else if(n >= 417500000){
			count = 104374996;start = 417500000;
			}else if(n >= 417000000){
			count = 104249996;start = 417000000;
			}else if(n >= 416500000){
			count = 104124997;start = 416500000;
			}else if(n >= 416000000){
			count = 103999995;start = 416000000;
			}else if(n >= 415500000){
			count = 103874996;start = 415500000;
			}else if(n >= 415000000){
			count = 103749997;start = 415000000;
			}else if(n >= 414500000){
			count = 103624997;start = 414500000;
			}else if(n >= 414000000){
			count = 103499996;start = 414000000;
			}else if(n >= 413500000){
			count = 103374996;start = 413500000;
			}else if(n >= 413000000){
			count = 103249997;start = 413000000;
			}else if(n >= 412500000){
			count = 103124998;start = 412500000;
			}else if(n >= 412000000){
			count = 102999996;start = 412000000;
			}else if(n >= 411500000){
			count = 102874997;start = 411500000;
			}else if(n >= 411000000){
			count = 102749997;start = 411000000;
			}else if(n >= 410500000){
			count = 102624997;start = 410500000;
			}else if(n >= 410000000){
			count = 102499996;start = 410000000;
			}else if(n >= 409500000){
			count = 102374996;start = 409500000;
			}else if(n >= 409000000){
			count = 102249997;start = 409000000;
			}else if(n >= 408500000){
			count = 102124996;start = 408500000;
			}else if(n >= 408000000){
			count = 101999996;start = 408000000;
			}else if(n >= 407500000){
			count = 101874997;start = 407500000;
			}else if(n >= 407000000){
			count = 101749996;start = 407000000;
			}else if(n >= 406500000){
			count = 101624997;start = 406500000;
			}else if(n >= 406000000){
			count = 101499996;start = 406000000;
			}else if(n >= 405500000){
			count = 101374997;start = 405500000;
			}else if(n >= 405000000){
			count = 101249997;start = 405000000;
			}else if(n >= 404500000){
			count = 101124997;start = 404500000;
			}else if(n >= 404000000){
			count = 100999997;start = 404000000;
			}else if(n >= 403500000){
			count = 100874996;start = 403500000;
			}else if(n >= 403000000){
			count = 100749997;start = 403000000;
			}else if(n >= 402500000){
			count = 100624998;start = 402500000;
			}else if(n >= 402000000){
			count = 100499997;start = 402000000;
			}else if(n >= 401500000){
			count = 100374997;start = 401500000;
			}else if(n >= 401000000){
			count = 100249997;start = 401000000;
			}else if(n >= 400500000){
			count = 100124998;start = 400500000;
			}else if(n >= 400000000){
			count = 99999997;start = 400000000;
			}else if(n >= 399500000){
			count = 99874996;start = 399500000;
			}else if(n >= 399000000){
			count = 99749997;start = 399000000;
			}else if(n >= 398500000){
			count = 99624997;start = 398500000;
			}else if(n >= 398000000){
			count = 99499996;start = 398000000;
			}else if(n >= 397500000){
			count = 99374997;start = 397500000;
			}else if(n >= 397000000){
			count = 99249997;start = 397000000;
			}else if(n >= 396500000){
			count = 99124998;start = 396500000;
			}else if(n >= 396000000){
			count = 98999996;start = 396000000;
			}else if(n >= 395500000){
			count = 98874997;start = 395500000;
			}else if(n >= 395000000){
			count = 98749998;start = 395000000;
			}else if(n >= 394500000){
			count = 98624996;start = 394500000;
			}else if(n >= 394000000){
			count = 98499997;start = 394000000;
			}else if(n >= 393500000){
			count = 98374997;start = 393500000;
			}else if(n >= 393000000){
			count = 98249998;start = 393000000;
			}else if(n >= 392500000){
			count = 98124997;start = 392500000;
			}else if(n >= 392000000){
			count = 97999997;start = 392000000;
			}else if(n >= 391500000){
			count = 97874998;start = 391500000;
			}else if(n >= 391000000){
			count = 97749997;start = 391000000;
			}else if(n >= 390500000){
			count = 97624995;start = 390500000;
			}else if(n >= 390000000){
			count = 97499996;start = 390000000;
			}else if(n >= 389500000){
			count = 97374996;start = 389500000;
			}else if(n >= 389000000){
			count = 97249996;start = 389000000;
			}else if(n >= 388500000){
			count = 97124995;start = 388500000;
			}else if(n >= 388000000){
			count = 96999996;start = 388000000;
			}else if(n >= 387500000){
			count = 96874997;start = 387500000;
			}else if(n >= 387000000){
			count = 96749996;start = 387000000;
			}else if(n >= 386500000){
			count = 96624996;start = 386500000;
			}else if(n >= 386000000){
			count = 96499996;start = 386000000;
			}else if(n >= 385500000){
			count = 96374996;start = 385500000;
			}else if(n >= 385000000){
			count = 96249997;start = 385000000;
			}else if(n >= 384500000){
			count = 96124996;start = 384500000;
			}else if(n >= 384000000){
			count = 95999997;start = 384000000;
			}else if(n >= 383500000){
			count = 95874996;start = 383500000;
			}else if(n >= 383000000){
			count = 95749997;start = 383000000;
			}else if(n >= 382500000){
			count = 95624997;start = 382500000;
			}else if(n >= 382000000){
			count = 95499996;start = 382000000;
			}else if(n >= 381500000){
			count = 95374997;start = 381500000;
			}else if(n >= 381000000){
			count = 95249997;start = 381000000;
			}else if(n >= 380500000){
			count = 95124996;start = 380500000;
			}else if(n >= 380000000){
			count = 94999996;start = 380000000;
			}else if(n >= 379500000){
			count = 94874996;start = 379500000;
			}else if(n >= 379000000){
			count = 94749997;start = 379000000;
			}else if(n >= 378500000){
			count = 94624995;start = 378500000;
			}else if(n >= 378000000){
			count = 94499996;start = 378000000;
			}else if(n >= 377500000){
			count = 94374997;start = 377500000;
			}else if(n >= 377000000){
			count = 94249997;start = 377000000;
			}else if(n >= 376500000){
			count = 94124996;start = 376500000;
			}else if(n >= 376000000){
			count = 93999996;start = 376000000;
			}else if(n >= 375500000){
			count = 93874997;start = 375500000;
			}else if(n >= 375000000){
			count = 93749998;start = 375000000;
			}else if(n >= 374500000){
			count = 93624996;start = 374500000;
			}else if(n >= 374000000){
			count = 93499997;start = 374000000;
			}else if(n >= 373500000){
			count = 93374997;start = 373500000;
			}else if(n >= 373000000){
			count = 93249996;start = 373000000;
			}else if(n >= 372500000){
			count = 93124997;start = 372500000;
			}else if(n >= 372000000){
			count = 92999997;start = 372000000;
			}else if(n >= 371500000){
			count = 92874998;start = 371500000;
			}else if(n >= 371000000){
			count = 92749995;start = 371000000;
			}else if(n >= 370500000){
			count = 92624996;start = 370500000;
			}else if(n >= 370000000){
			count = 92499997;start = 370000000;
			}else if(n >= 369500000){
			count = 92374996;start = 369500000;
			}else if(n >= 369000000){
			count = 92249996;start = 369000000;
			}else if(n >= 368500000){
			count = 92124996;start = 368500000;
			}else if(n >= 368000000){
			count = 91999997;start = 368000000;
			}else if(n >= 367500000){
			count = 91874997;start = 367500000;
			}else if(n >= 367000000){
			count = 91749996;start = 367000000;
			}else if(n >= 366500000){
			count = 91624997;start = 366500000;
			}else if(n >= 366000000){
			count = 91499996;start = 366000000;
			}else if(n >= 365500000){
			count = 91374997;start = 365500000;
			}else if(n >= 365000000){
			count = 91249997;start = 365000000;
			}else if(n >= 364500000){
			count = 91124997;start = 364500000;
			}else if(n >= 364000000){
			count = 90999997;start = 364000000;
			}else if(n >= 363500000){
			count = 90874997;start = 363500000;
			}else if(n >= 363000000){
			count = 90749997;start = 363000000;
			}else if(n >= 362500000){
			count = 90624998;start = 362500000;
			}else if(n >= 362000000){
			count = 90499997;start = 362000000;
			}else if(n >= 361500000){
			count = 90374998;start = 361500000;
			}else if(n >= 361000000){
			count = 90249996;start = 361000000;
			}else if(n >= 360500000){
			count = 90124996;start = 360500000;
			}else if(n >= 360000000){
			count = 89999997;start = 360000000;
			}else if(n >= 359500000){
			count = 89874997;start = 359500000;
			}else if(n >= 359000000){
			count = 89749997;start = 359000000;
			}else if(n >= 358500000){
			count = 89624996;start = 358500000;
			}else if(n >= 358000000){
			count = 89499997;start = 358000000;
			}else if(n >= 357500000){
			count = 89374998;start = 357500000;
			}else if(n >= 357000000){
			count = 89249996;start = 357000000;
			}else if(n >= 356500000){
			count = 89124997;start = 356500000;
			}else if(n >= 356000000){
			count = 88999997;start = 356000000;
			}else if(n >= 355500000){
			count = 88874998;start = 355500000;
			}else if(n >= 355000000){
			count = 88749997;start = 355000000;
			}else if(n >= 354500000){
			count = 88624997;start = 354500000;
			}else if(n >= 354000000){
			count = 88499998;start = 354000000;
			}else if(n >= 353500000){
			count = 88374996;start = 353500000;
			}else if(n >= 353000000){
			count = 88249997;start = 353000000;
			}else if(n >= 352500000){
			count = 88124998;start = 352500000;
			}else if(n >= 352000000){
			count = 87999998;start = 352000000;
			}else if(n >= 351500000){
			count = 87874996;start = 351500000;
			}else if(n >= 351000000){
			count = 87749996;start = 351000000;
			}else if(n >= 350500000){
			count = 87624997;start = 350500000;
			}else if(n >= 350000000){
			count = 87499998;start = 350000000;
			}else if(n >= 349500000){
			count = 87374996;start = 349500000;
			}else if(n >= 349000000){
			count = 87249997;start = 349000000;
			}else if(n >= 348500000){
			count = 87124997;start = 348500000;
			}else if(n >= 348000000){
			count = 86999997;start = 348000000;
			}else if(n >= 347500000){
			count = 86874997;start = 347500000;
			}else if(n >= 347000000){
			count = 86749997;start = 347000000;
			}else if(n >= 346500000){
			count = 86624998;start = 346500000;
			}else if(n >= 346000000){
			count = 86499997;start = 346000000;
			}else if(n >= 345500000){
			count = 86374997;start = 345500000;
			}else if(n >= 345000000){
			count = 86249998;start = 345000000;
			}else if(n >= 344500000){
			count = 86124997;start = 344500000;
			}else if(n >= 344000000){
			count = 85999998;start = 344000000;
			}else if(n >= 343500000){
			count = 85874997;start = 343500000;
			}else if(n >= 343000000){
			count = 85749998;start = 343000000;
			}else if(n >= 342500000){
			count = 85624998;start = 342500000;
			}else if(n >= 342000000){
			count = 85499998;start = 342000000;
			}else if(n >= 341500000){
			count = 85374996;start = 341500000;
			}else if(n >= 341000000){
			count = 85249995;start = 341000000;
			}else if(n >= 340500000){
			count = 85124996;start = 340500000;
			}else if(n >= 340000000){
			count = 84999997;start = 340000000;
			}else if(n >= 339500000){
			count = 84874996;start = 339500000;
			}else if(n >= 339000000){
			count = 84749996;start = 339000000;
			}else if(n >= 338500000){
			count = 84624996;start = 338500000;
			}else if(n >= 338000000){
			count = 84499997;start = 338000000;
			}else if(n >= 337500000){
			count = 84374997;start = 337500000;
			}else if(n >= 337000000){
			count = 84249996;start = 337000000;
			}else if(n >= 336500000){
			count = 84124997;start = 336500000;
			}else if(n >= 336000000){
			count = 83999997;start = 336000000;
			}else if(n >= 335500000){
			count = 83874996;start = 335500000;
			}else if(n >= 335000000){
			count = 83749997;start = 335000000;
			}else if(n >= 334500000){
			count = 83624997;start = 334500000;
			}else if(n >= 334000000){
			count = 83499998;start = 334000000;
			}else if(n >= 333500000){
			count = 83374996;start = 333500000;
			}else if(n >= 333000000){
			count = 83249997;start = 333000000;
			}else if(n >= 332500000){
			count = 83124998;start = 332500000;
			}else if(n >= 332000000){
			count = 82999995;start = 332000000;
			}else if(n >= 331500000){
			count = 82874996;start = 331500000;
			}else if(n >= 331000000){
			count = 82749996;start = 331000000;
			}else if(n >= 330500000){
			count = 82624997;start = 330500000;
			}else if(n >= 330000000){
			count = 82499996;start = 330000000;
			}else if(n >= 329500000){
			count = 82374996;start = 329500000;
			}else if(n >= 329000000){
			count = 82249997;start = 329000000;
			}else if(n >= 328500000){
			count = 82124996;start = 328500000;
			}else if(n >= 328000000){
			count = 81999996;start = 328000000;
			}else if(n >= 327500000){
			count = 81874997;start = 327500000;
			}else if(n >= 327000000){
			count = 81749997;start = 327000000;
			}else if(n >= 326500000){
			count = 81624997;start = 326500000;
			}else if(n >= 326000000){
			count = 81499996;start = 326000000;
			}else if(n >= 325500000){
			count = 81374997;start = 325500000;
			}else if(n >= 325000000){
			count = 81249998;start = 325000000;
			}else if(n >= 324500000){
			count = 81124997;start = 324500000;
			}else if(n >= 324000000){
			count = 80999997;start = 324000000;
			}else if(n >= 323500000){
			count = 80874997;start = 323500000;
			}else if(n >= 323000000){
			count = 80749997;start = 323000000;
			}else if(n >= 322500000){
			count = 80624998;start = 322500000;
			}else if(n >= 322000000){
			count = 80499996;start = 322000000;
			}else if(n >= 321500000){
			count = 80374997;start = 321500000;
			}else if(n >= 321000000){
			count = 80249996;start = 321000000;
			}else if(n >= 320500000){
			count = 80124997;start = 320500000;
			}else if(n >= 320000000){
			count = 79999997;start = 320000000;
			}else if(n >= 319500000){
			count = 79874996;start = 319500000;
			}else if(n >= 319000000){
			count = 79749997;start = 319000000;
			}else if(n >= 318500000){
			count = 79624997;start = 318500000;
			}else if(n >= 318000000){
			count = 79499997;start = 318000000;
			}else if(n >= 317500000){
			count = 79374997;start = 317500000;
			}else if(n >= 317000000){
			count = 79249997;start = 317000000;
			}else if(n >= 316500000){
			count = 79124998;start = 316500000;
			}else if(n >= 316000000){
			count = 78999996;start = 316000000;
			}else if(n >= 315500000){
			count = 78874997;start = 315500000;
			}else if(n >= 315000000){
			count = 78749998;start = 315000000;
			}else if(n >= 314500000){
			count = 78624998;start = 314500000;
			}else if(n >= 314000000){
			count = 78499997;start = 314000000;
			}else if(n >= 313500000){
			count = 78374997;start = 313500000;
			}else if(n >= 313000000){
			count = 78249998;start = 313000000;
			}else if(n >= 312500000){
			count = 78124999;start = 312500000;
			}else if(n >= 312000000){
			count = 77999996;start = 312000000;
			}else if(n >= 311500000){
			count = 77874997;start = 311500000;
			}else if(n >= 311000000){
			count = 77749997;start = 311000000;
			}else if(n >= 310500000){
			count = 77624996;start = 310500000;
			}else if(n >= 310000000){
			count = 77499997;start = 310000000;
			}else if(n >= 309500000){
			count = 77374997;start = 309500000;
			}else if(n >= 309000000){
			count = 77249998;start = 309000000;
			}else if(n >= 308500000){
			count = 77124996;start = 308500000;
			}else if(n >= 308000000){
			count = 76999997;start = 308000000;
			}else if(n >= 307500000){
			count = 76874998;start = 307500000;
			}else if(n >= 307000000){
			count = 76749997;start = 307000000;
			}else if(n >= 306500000){
			count = 76624997;start = 306500000;
			}else if(n >= 306000000){
			count = 76499997;start = 306000000;
			}else if(n >= 305500000){
			count = 76374998;start = 305500000;
			}else if(n >= 305000000){
			count = 76249998;start = 305000000;
			}else if(n >= 304500000){
			count = 76124997;start = 304500000;
			}else if(n >= 304000000){
			count = 75999998;start = 304000000;
			}else if(n >= 303500000){
			count = 75874997;start = 303500000;
			}else if(n >= 303000000){
			count = 75749998;start = 303000000;
			}else if(n >= 302500000){
			count = 75624997;start = 302500000;
			}else if(n >= 302000000){
			count = 75499997;start = 302000000;
			}else if(n >= 301500000){
			count = 75374997;start = 301500000;
			}else if(n >= 301000000){
			count = 75249997;start = 301000000;
			}else if(n >= 300500000){
			count = 75124997;start = 300500000;
			}else if(n >= 300000000){
			count = 74999998;start = 300000000;
			}else if(n >= 299500000){
			count = 74874997;start = 299500000;
			}else if(n >= 299000000){
			count = 74749998;start = 299000000;
			}else if(n >= 298500000){
			count = 74624997;start = 298500000;
			}else if(n >= 298000000){
			count = 74499997;start = 298000000;
			}else if(n >= 297500000){
			count = 74374998;start = 297500000;
			}else if(n >= 297000000){
			count = 74249998;start = 297000000;
			}else if(n >= 296500000){
			count = 74124998;start = 296500000;
			}else if(n >= 296000000){
			count = 73999997;start = 296000000;
			}else if(n >= 295500000){
			count = 73874998;start = 295500000;
			}else if(n >= 295000000){
			count = 73749999;start = 295000000;
			}else if(n >= 294500000){
			count = 73624997;start = 294500000;
			}else if(n >= 294000000){
			count = 73499998;start = 294000000;
			}else if(n >= 293500000){
			count = 73374998;start = 293500000;
			}else if(n >= 293000000){
			count = 73249999;start = 293000000;
			}else if(n >= 292500000){
			count = 73124996;start = 292500000;
			}else if(n >= 292000000){
			count = 72999996;start = 292000000;
			}else if(n >= 291500000){
			count = 72874997;start = 291500000;
			}else if(n >= 291000000){
			count = 72749995;start = 291000000;
			}else if(n >= 290500000){
			count = 72624996;start = 290500000;
			}else if(n >= 290000000){
			count = 72499997;start = 290000000;
			}else if(n >= 289500000){
			count = 72374997;start = 289500000;
			}else if(n >= 289000000){
			count = 72249996;start = 289000000;
			}else if(n >= 288500000){
			count = 72124996;start = 288500000;
			}else if(n >= 288000000){
			count = 71999997;start = 288000000;
			}else if(n >= 287500000){
			count = 71874998;start = 287500000;
			}else if(n >= 287000000){
			count = 71749996;start = 287000000;
			}else if(n >= 286500000){
			count = 71624997;start = 286500000;
			}else if(n >= 286000000){
			count = 71499997;start = 286000000;
			}else if(n >= 285500000){
			count = 71374997;start = 285500000;
			}else if(n >= 285000000){
			count = 71249997;start = 285000000;
			}else if(n >= 284500000){
			count = 71124997;start = 284500000;
			}else if(n >= 284000000){
			count = 70999998;start = 284000000;
			}else if(n >= 283500000){
			count = 70874997;start = 283500000;
			}else if(n >= 283000000){
			count = 70749996;start = 283000000;
			}else if(n >= 282500000){
			count = 70624997;start = 282500000;
			}else if(n >= 282000000){
			count = 70499996;start = 282000000;
			}else if(n >= 281500000){
			count = 70374997;start = 281500000;
			}else if(n >= 281000000){
			count = 70249996;start = 281000000;
			}else if(n >= 280500000){
			count = 70124997;start = 280500000;
			}else if(n >= 280000000){
			count = 69999997;start = 280000000;
			}else if(n >= 279500000){
			count = 69874997;start = 279500000;
			}else if(n >= 279000000){
			count = 69749997;start = 279000000;
			}else if(n >= 278500000){
			count = 69624996;start = 278500000;
			}else if(n >= 278000000){
			count = 69499997;start = 278000000;
			}else if(n >= 277500000){
			count = 69374998;start = 277500000;
			}else if(n >= 277000000){
			count = 69249997;start = 277000000;
			}else if(n >= 276500000){
			count = 69124997;start = 276500000;
			}else if(n >= 276000000){
			count = 68999997;start = 276000000;
			}else if(n >= 275500000){
			count = 68874998;start = 275500000;
			}else if(n >= 275000000){
			count = 68749998;start = 275000000;
			}else if(n >= 274500000){
			count = 68624997;start = 274500000;
			}else if(n >= 274000000){
			count = 68499998;start = 274000000;
			}else if(n >= 273500000){
			count = 68374998;start = 273500000;
			}else if(n >= 273000000){
			count = 68249996;start = 273000000;
			}else if(n >= 272500000){
			count = 68124997;start = 272500000;
			}else if(n >= 272000000){
			count = 67999997;start = 272000000;
			}else if(n >= 271500000){
			count = 67874998;start = 271500000;
			}else if(n >= 271000000){
			count = 67749996;start = 271000000;
			}else if(n >= 270500000){
			count = 67624997;start = 270500000;
			}else if(n >= 270000000){
			count = 67499998;start = 270000000;
			}else if(n >= 269500000){
			count = 67374996;start = 269500000;
			}else if(n >= 269000000){
			count = 67249997;start = 269000000;
			}else if(n >= 268500000){
			count = 67124997;start = 268500000;
			}else if(n >= 268000000){
			count = 66999998;start = 268000000;
			}else if(n >= 267500000){
			count = 66874997;start = 267500000;
			}else if(n >= 267000000){
			count = 66749997;start = 267000000;
			}else if(n >= 266500000){
			count = 66624998;start = 266500000;
			}else if(n >= 266000000){
			count = 66499997;start = 266000000;
			}else if(n >= 265500000){
			count = 66374997;start = 265500000;
			}else if(n >= 265000000){
			count = 66249998;start = 265000000;
			}else if(n >= 264500000){
			count = 66124998;start = 264500000;
			}else if(n >= 264000000){
			count = 65999998;start = 264000000;
			}else if(n >= 263500000){
			count = 65874996;start = 263500000;
			}else if(n >= 263000000){
			count = 65749997;start = 263000000;
			}else if(n >= 262500000){
			count = 65624998;start = 262500000;
			}else if(n >= 262000000){
			count = 65499997;start = 262000000;
			}else if(n >= 261500000){
			count = 65374997;start = 261500000;
			}else if(n >= 261000000){
			count = 65249997;start = 261000000;
			}else if(n >= 260500000){
			count = 65124997;start = 260500000;
			}else if(n >= 260000000){
			count = 64999998;start = 260000000;
			}else if(n >= 259500000){
			count = 64874997;start = 259500000;
			}else if(n >= 259000000){
			count = 64749998;start = 259000000;
			}else if(n >= 258500000){
			count = 64624997;start = 258500000;
			}else if(n >= 258000000){
			count = 64499998;start = 258000000;
			}else if(n >= 257500000){
			count = 64374998;start = 257500000;
			}else if(n >= 257000000){
			count = 64249997;start = 257000000;
			}else if(n >= 256500000){
			count = 64124998;start = 256500000;
			}else if(n >= 256000000){
			count = 63999998;start = 256000000;
			}else if(n >= 255500000){
			count = 63874998;start = 255500000;
			}else if(n >= 255000000){
			count = 63749998;start = 255000000;
			}else if(n >= 254500000){
			count = 63624998;start = 254500000;
			}else if(n >= 254000000){
			count = 63499999;start = 254000000;
			}else if(n >= 253500000){
			count = 63374996;start = 253500000;
			}else if(n >= 253000000){
			count = 63249997;start = 253000000;
			}else if(n >= 252500000){
			count = 63124998;start = 252500000;
			}else if(n >= 252000000){
			count = 62999998;start = 252000000;
			}else if(n >= 251500000){
			count = 62874997;start = 251500000;
			}else if(n >= 251000000){
			count = 62749997;start = 251000000;
			}else if(n >= 250500000){
			count = 62624998;start = 250500000;
			}else if(n >= 250000000){
			count = 62499999;start = 250000000;
			}else if(n >= 249500000){
			count = 62374997;start = 249500000;
			}else if(n >= 249000000){
			count = 62249998;start = 249000000;
			}else if(n >= 248500000){
			count = 62124998;start = 248500000;
			}else if(n >= 248000000){
			count = 61999997;start = 248000000;
			}else if(n >= 247500000){
			count = 61874998;start = 247500000;
			}else if(n >= 247000000){
			count = 61749998;start = 247000000;
			}else if(n >= 246500000){
			count = 61624999;start = 246500000;
			}else if(n >= 246000000){
			count = 61499997;start = 246000000;
			}else if(n >= 245500000){
			count = 61374998;start = 245500000;
			}else if(n >= 245000000){
			count = 61249999;start = 245000000;
			}else if(n >= 244500000){
			count = 61124998;start = 244500000;
			}else if(n >= 244000000){
			count = 60999995;start = 244000000;
			}else if(n >= 243500000){
			count = 60874995;start = 243500000;
			}else if(n >= 243000000){
			count = 60749996;start = 243000000;
			}else if(n >= 242500000){
			count = 60624996;start = 242500000;
			}else if(n >= 242000000){
			count = 60499995;start = 242000000;
			}else if(n >= 241500000){
			count = 60374996;start = 241500000;
			}else if(n >= 241000000){
			count = 60249995;start = 241000000;
			}else if(n >= 240500000){
			count = 60124996;start = 240500000;
			}else if(n >= 240000000){
			count = 59999996;start = 240000000;
			}else if(n >= 239500000){
			count = 59874996;start = 239500000;
			}else if(n >= 239000000){
			count = 59749996;start = 239000000;
			}else if(n >= 238500000){
			count = 59624996;start = 238500000;
			}else if(n >= 238000000){
			count = 59499996;start = 238000000;
			}else if(n >= 237500000){
			count = 59374997;start = 237500000;
			}else if(n >= 237000000){
			count = 59249996;start = 237000000;
			}else if(n >= 236500000){
			count = 59124997;start = 236500000;
			}else if(n >= 236000000){
			count = 58999996;start = 236000000;
			}else if(n >= 235500000){
			count = 58874996;start = 235500000;
			}else if(n >= 235000000){
			count = 58749997;start = 235000000;
			}else if(n >= 234500000){
			count = 58624997;start = 234500000;
			}else if(n >= 234000000){
			count = 58499996;start = 234000000;
			}else if(n >= 233500000){
			count = 58374995;start = 233500000;
			}else if(n >= 233000000){
			count = 58249996;start = 233000000;
			}else if(n >= 232500000){
			count = 58124997;start = 232500000;
			}else if(n >= 232000000){
			count = 57999995;start = 232000000;
			}else if(n >= 231500000){
			count = 57874996;start = 231500000;
			}else if(n >= 231000000){
			count = 57749996;start = 231000000;
			}else if(n >= 230500000){
			count = 57624997;start = 230500000;
			}else if(n >= 230000000){
			count = 57499996;start = 230000000;
			}else if(n >= 229500000){
			count = 57374996;start = 229500000;
			}else if(n >= 229000000){
			count = 57249997;start = 229000000;
			}else if(n >= 228500000){
			count = 57124995;start = 228500000;
			}else if(n >= 228000000){
			count = 56999996;start = 228000000;
			}else if(n >= 227500000){
			count = 56874997;start = 227500000;
			}else if(n >= 227000000){
			count = 56749997;start = 227000000;
			}else if(n >= 226500000){
			count = 56624996;start = 226500000;
			}else if(n >= 226000000){
			count = 56499996;start = 226000000;
			}else if(n >= 225500000){
			count = 56374997;start = 225500000;
			}else if(n >= 225000000){
			count = 56249998;start = 225000000;
			}else if(n >= 224500000){
			count = 56124995;start = 224500000;
			}else if(n >= 224000000){
			count = 55999996;start = 224000000;
			}else if(n >= 223500000){
			count = 55874996;start = 223500000;
			}else if(n >= 223000000){
			count = 55749996;start = 223000000;
			}else if(n >= 222500000){
			count = 55624996;start = 222500000;
			}else if(n >= 222000000){
			count = 55499996;start = 222000000;
			}else if(n >= 221500000){
			count = 55374997;start = 221500000;
			}else if(n >= 221000000){
			count = 55249996;start = 221000000;
			}else if(n >= 220500000){
			count = 55124996;start = 220500000;
			}else if(n >= 220000000){
			count = 54999997;start = 220000000;
			}else if(n >= 219500000){
			count = 54874996;start = 219500000;
			}else if(n >= 219000000){
			count = 54749997;start = 219000000;
			}else if(n >= 218500000){
			count = 54624996;start = 218500000;
			}else if(n >= 218000000){
			count = 54499997;start = 218000000;
			}else if(n >= 217500000){
			count = 54374997;start = 217500000;
			}else if(n >= 217000000){
			count = 54249997;start = 217000000;
			}else if(n >= 216500000){
			count = 54124997;start = 216500000;
			}else if(n >= 216000000){
			count = 53999996;start = 216000000;
			}else if(n >= 215500000){
			count = 53874997;start = 215500000;
			}else if(n >= 215000000){
			count = 53749998;start = 215000000;
			}else if(n >= 214500000){
			count = 53624996;start = 214500000;
			}else if(n >= 214000000){
			count = 53499996;start = 214000000;
			}else if(n >= 213500000){
			count = 53374996;start = 213500000;
			}else if(n >= 213000000){
			count = 53249997;start = 213000000;
			}else if(n >= 212500000){
			count = 53124997;start = 212500000;
			}else if(n >= 212000000){
			count = 52999996;start = 212000000;
			}else if(n >= 211500000){
			count = 52874997;start = 211500000;
			}else if(n >= 211000000){
			count = 52749997;start = 211000000;
			}else if(n >= 210500000){
			count = 52624996;start = 210500000;
			}else if(n >= 210000000){
			count = 52499997;start = 210000000;
			}else if(n >= 209500000){
			count = 52374997;start = 209500000;
			}else if(n >= 209000000){
			count = 52249998;start = 209000000;
			}else if(n >= 208500000){
			count = 52124996;start = 208500000;
			}else if(n >= 208000000){
			count = 51999997;start = 208000000;
			}else if(n >= 207500000){
			count = 51874998;start = 207500000;
			}else if(n >= 207000000){
			count = 51749996;start = 207000000;
			}else if(n >= 206500000){
			count = 51624997;start = 206500000;
			}else if(n >= 206000000){
			count = 51499997;start = 206000000;
			}else if(n >= 205500000){
			count = 51374998;start = 205500000;
			}else if(n >= 205000000){
			count = 51249996;start = 205000000;
			}else if(n >= 204500000){
			count = 51124996;start = 204500000;
			}else if(n >= 204000000){
			count = 50999997;start = 204000000;
			}else if(n >= 203500000){
			count = 50874996;start = 203500000;
			}else if(n >= 203000000){
			count = 50749996;start = 203000000;
			}else if(n >= 202500000){
			count = 50624997;start = 202500000;
			}else if(n >= 202000000){
			count = 50499997;start = 202000000;
			}else if(n >= 201500000){
			count = 50374997;start = 201500000;
			}else if(n >= 201000000){
			count = 50249996;start = 201000000;
			}else if(n >= 200500000){
			count = 50124997;start = 200500000;
			}else if(n >= 200000000){
			count = 49999998;start = 200000000;
			}else if(n >= 199500000){
			count = 49874997;start = 199500000;
			}else if(n >= 199000000){
			count = 49749997;start = 199000000;
			}else if(n >= 198500000){
			count = 49624997;start = 198500000;
			}else if(n >= 198000000){
			count = 49499997;start = 198000000;
			}else if(n >= 197500000){
			count = 49374998;start = 197500000;
			}else if(n >= 197000000){
			count = 49249997;start = 197000000;
			}else if(n >= 196500000){
			count = 49124998;start = 196500000;
			}else if(n >= 196000000){
			count = 48999997;start = 196000000;
			}else if(n >= 195500000){
			count = 48874998;start = 195500000;
			}else if(n >= 195000000){
			count = 48749996;start = 195000000;
			}else if(n >= 194500000){
			count = 48624995;start = 194500000;
			}else if(n >= 194000000){
			count = 48499996;start = 194000000;
			}else if(n >= 193500000){
			count = 48374996;start = 193500000;
			}else if(n >= 193000000){
			count = 48249996;start = 193000000;
			}else if(n >= 192500000){
			count = 48124996;start = 192500000;
			}else if(n >= 192000000){
			count = 47999996;start = 192000000;
			}else if(n >= 191500000){
			count = 47874997;start = 191500000;
			}else if(n >= 191000000){
			count = 47749995;start = 191000000;
			}else if(n >= 190500000){
			count = 47624996;start = 190500000;
			}else if(n >= 190000000){
			count = 47499997;start = 190000000;
			}else if(n >= 189500000){
			count = 47374997;start = 189500000;
			}else if(n >= 189000000){
			count = 47249996;start = 189000000;
			}else if(n >= 188500000){
			count = 47124996;start = 188500000;
			}else if(n >= 188000000){
			count = 46999997;start = 188000000;
			}else if(n >= 187500000){
			count = 46874998;start = 187500000;
			}else if(n >= 187000000){
			count = 46749996;start = 187000000;
			}else if(n >= 186500000){
			count = 46624997;start = 186500000;
			}else if(n >= 186000000){
			count = 46499997;start = 186000000;
			}else if(n >= 185500000){
			count = 46374995;start = 185500000;
			}else if(n >= 185000000){
			count = 46249996;start = 185000000;
			}else if(n >= 184500000){
			count = 46124996;start = 184500000;
			}else if(n >= 184000000){
			count = 45999997;start = 184000000;
			}else if(n >= 183500000){
			count = 45874995;start = 183500000;
			}else if(n >= 183000000){
			count = 45749996;start = 183000000;
			}else if(n >= 182500000){
			count = 45624997;start = 182500000;
			}else if(n >= 182000000){
			count = 45499996;start = 182000000;
			}else if(n >= 181500000){
			count = 45374996;start = 181500000;
			}else if(n >= 181000000){
			count = 45249996;start = 181000000;
			}else if(n >= 180500000){
			count = 45124997;start = 180500000;
			}else if(n >= 180000000){
			count = 44999997;start = 180000000;
			}else if(n >= 179500000){
			count = 44874996;start = 179500000;
			}else if(n >= 179000000){
			count = 44749997;start = 179000000;
			}else if(n >= 178500000){
			count = 44624996;start = 178500000;
			}else if(n >= 178000000){
			count = 44499997;start = 178000000;
			}else if(n >= 177500000){
			count = 44374997;start = 177500000;
			}else if(n >= 177000000){
			count = 44249997;start = 177000000;
			}else if(n >= 176500000){
			count = 44124997;start = 176500000;
			}else if(n >= 176000000){
			count = 43999997;start = 176000000;
			}else if(n >= 175500000){
			count = 43874996;start = 175500000;
			}else if(n >= 175000000){
			count = 43749997;start = 175000000;
			}else if(n >= 174500000){
			count = 43624996;start = 174500000;
			}else if(n >= 174000000){
			count = 43499997;start = 174000000;
			}else if(n >= 173500000){
			count = 43374996;start = 173500000;
			}else if(n >= 173000000){
			count = 43249996;start = 173000000;
			}else if(n >= 172500000){
			count = 43124997;start = 172500000;
			}else if(n >= 172000000){
			count = 42999997;start = 172000000;
			}else if(n >= 171500000){
			count = 42874997;start = 171500000;
			}else if(n >= 171000000){
			count = 42749996;start = 171000000;
			}else if(n >= 170500000){
			count = 42624997;start = 170500000;
			}else if(n >= 170000000){
			count = 42499998;start = 170000000;
			}else if(n >= 169500000){
			count = 42374996;start = 169500000;
			}else if(n >= 169000000){
			count = 42249997;start = 169000000;
			}else if(n >= 168500000){
			count = 42124997;start = 168500000;
			}else if(n >= 168000000){
			count = 41999998;start = 168000000;
			}else if(n >= 167500000){
			count = 41874997;start = 167500000;
			}else if(n >= 167000000){
			count = 41749997;start = 167000000;
			}else if(n >= 166500000){
			count = 41624998;start = 166500000;
			}else if(n >= 166000000){
			count = 41499995;start = 166000000;
			}else if(n >= 165500000){
			count = 41374996;start = 165500000;
			}else if(n >= 165000000){
			count = 41249997;start = 165000000;
			}else if(n >= 164500000){
			count = 41124997;start = 164500000;
			}else if(n >= 164000000){
			count = 40999996;start = 164000000;
			}else if(n >= 163500000){
			count = 40874996;start = 163500000;
			}else if(n >= 163000000){
			count = 40749997;start = 163000000;
			}else if(n >= 162500000){
			count = 40624998;start = 162500000;
			}else if(n >= 162000000){
			count = 40499996;start = 162000000;
			}else if(n >= 161500000){
			count = 40374997;start = 161500000;
			}else if(n >= 161000000){
			count = 40249997;start = 161000000;
			}else if(n >= 160500000){
			count = 40124997;start = 160500000;
			}else if(n >= 160000000){
			count = 39999997;start = 160000000;
			}else if(n >= 159500000){
			count = 39874997;start = 159500000;
			}else if(n >= 159000000){
			count = 39749998;start = 159000000;
			}else if(n >= 158500000){
			count = 39624997;start = 158500000;
			}else if(n >= 158000000){
			count = 39499997;start = 158000000;
			}else if(n >= 157500000){
			count = 39374998;start = 157500000;
			}else if(n >= 157000000){
			count = 39249997;start = 157000000;
			}else if(n >= 156500000){
			count = 39124998;start = 156500000;
			}else if(n >= 156000000){
			count = 38999996;start = 156000000;
			}else if(n >= 155500000){
			count = 38874997;start = 155500000;
			}else if(n >= 155000000){
			count = 38749997;start = 155000000;
			}else if(n >= 154500000){
			count = 38624997;start = 154500000;
			}else if(n >= 154000000){
			count = 38499997;start = 154000000;
			}else if(n >= 153500000){
			count = 38374996;start = 153500000;
			}else if(n >= 153000000){
			count = 38249997;start = 153000000;
			}else if(n >= 152500000){
			count = 38124998;start = 152500000;
			}else if(n >= 152000000){
			count = 37999997;start = 152000000;
			}else if(n >= 151500000){
			count = 37874997;start = 151500000;
			}else if(n >= 151000000){
			count = 37749997;start = 151000000;
			}else if(n >= 150500000){
			count = 37624998;start = 150500000;
			}else if(n >= 150000000){
			count = 37499998;start = 150000000;
			}else if(n >= 149500000){
			count = 37374997;start = 149500000;
			}else if(n >= 149000000){
			count = 37249998;start = 149000000;
			}else if(n >= 148500000){
			count = 37124998;start = 148500000;
			}else if(n >= 148000000){
			count = 36999997;start = 148000000;
			}else if(n >= 147500000){
			count = 36874998;start = 147500000;
			}else if(n >= 147000000){
			count = 36749998;start = 147000000;
			}else if(n >= 146500000){
			count = 36624999;start = 146500000;
			}else if(n >= 146000000){
			count = 36499995;start = 146000000;
			}else if(n >= 145500000){
			count = 36374996;start = 145500000;
			}else if(n >= 145000000){
			count = 36249997;start = 145000000;
			}else if(n >= 144500000){
			count = 36124995;start = 144500000;
			}else if(n >= 144000000){
			count = 35999996;start = 144000000;
			}else if(n >= 143500000){
			count = 35874996;start = 143500000;
			}else if(n >= 143000000){
			count = 35749997;start = 143000000;
			}else if(n >= 142500000){
			count = 35624996;start = 142500000;
			}else if(n >= 142000000){
			count = 35499996;start = 142000000;
			}else if(n >= 141500000){
			count = 35374997;start = 141500000;
			}else if(n >= 141000000){
			count = 35249996;start = 141000000;
			}else if(n >= 140500000){
			count = 35124996;start = 140500000;
			}else if(n >= 140000000){
			count = 34999997;start = 140000000;
			}else if(n >= 139500000){
			count = 34874997;start = 139500000;
			}else if(n >= 139000000){
			count = 34749997;start = 139000000;
			}else if(n >= 138500000){
			count = 34624996;start = 138500000;
			}else if(n >= 138000000){
			count = 34499997;start = 138000000;
			}else if(n >= 137500000){
			count = 34374998;start = 137500000;
			}else if(n >= 137000000){
			count = 34249997;start = 137000000;
			}else if(n >= 136500000){
			count = 34124996;start = 136500000;
			}else if(n >= 136000000){
			count = 33999996;start = 136000000;
			}else if(n >= 135500000){
			count = 33874996;start = 135500000;
			}else if(n >= 135000000){
			count = 33749997;start = 135000000;
			}else if(n >= 134500000){
			count = 33624996;start = 134500000;
			}else if(n >= 134000000){
			count = 33499997;start = 134000000;
			}else if(n >= 133500000){
			count = 33374996;start = 133500000;
			}else if(n >= 133000000){
			count = 33249997;start = 133000000;
			}else if(n >= 132500000){
			count = 33124997;start = 132500000;
			}else if(n >= 132000000){
			count = 32999996;start = 132000000;
			}else if(n >= 131500000){
			count = 32874997;start = 131500000;
			}else if(n >= 131000000){
			count = 32749997;start = 131000000;
			}else if(n >= 130500000){
			count = 32624997;start = 130500000;
			}else if(n >= 130000000){
			count = 32499997;start = 130000000;
			}else if(n >= 129500000){
			count = 32374997;start = 129500000;
			}else if(n >= 129000000){
			count = 32249998;start = 129000000;
			}else if(n >= 128500000){
			count = 32124996;start = 128500000;
			}else if(n >= 128000000){
			count = 31999997;start = 128000000;
			}else if(n >= 127500000){
			count = 31874998;start = 127500000;
			}else if(n >= 127000000){
			count = 31749998;start = 127000000;
			}else if(n >= 126500000){
			count = 31624996;start = 126500000;
			}else if(n >= 126000000){
			count = 31499996;start = 126000000;
			}else if(n >= 125500000){
			count = 31374997;start = 125500000;
			}else if(n >= 125000000){
			count = 31249998;start = 125000000;
			}else if(n >= 124500000){
			count = 31124996;start = 124500000;
			}else if(n >= 124000000){
			count = 30999997;start = 124000000;
			}else if(n >= 123500000){
			count = 30874997;start = 123500000;
			}else if(n >= 123000000){
			count = 30749996;start = 123000000;
			}else if(n >= 122500000){
			count = 30624997;start = 122500000;
			}else if(n >= 122000000){
			count = 30499997;start = 122000000;
			}else if(n >= 121500000){
			count = 30374998;start = 121500000;
			}else if(n >= 121000000){
			count = 30249996;start = 121000000;
			}else if(n >= 120500000){
			count = 30124997;start = 120500000;
			}else if(n >= 120000000){
			count = 29999998;start = 120000000;
			}else if(n >= 119500000){
			count = 29874997;start = 119500000;
			}else if(n >= 119000000){
			count = 29749997;start = 119000000;
			}else if(n >= 118500000){
			count = 29624997;start = 118500000;
			}else if(n >= 118000000){
			count = 29499998;start = 118000000;
			}else if(n >= 117500000){
			count = 29374998;start = 117500000;
			}else if(n >= 117000000){
			count = 29249996;start = 117000000;
			}else if(n >= 116500000){
			count = 29124997;start = 116500000;
			}else if(n >= 116000000){
			count = 28999996;start = 116000000;
			}else if(n >= 115500000){
			count = 28874997;start = 115500000;
			}else if(n >= 115000000){
			count = 28749997;start = 115000000;
			}else if(n >= 114500000){
			count = 28624997;start = 114500000;
			}else if(n >= 114000000){
			count = 28499997;start = 114000000;
			}else if(n >= 113500000){
			count = 28374997;start = 113500000;
			}else if(n >= 113000000){
			count = 28249997;start = 113000000;
			}else if(n >= 112500000){
			count = 28124998;start = 112500000;
			}else if(n >= 112000000){
			count = 27999997;start = 112000000;
			}else if(n >= 111500000){
			count = 27874998;start = 111500000;
			}else if(n >= 111000000){
			count = 27749997;start = 111000000;
			}else if(n >= 110500000){
			count = 27624997;start = 110500000;
			}else if(n >= 110000000){
			count = 27499998;start = 110000000;
			}else if(n >= 109500000){
			count = 27374998;start = 109500000;
			}else if(n >= 109000000){
			count = 27249998;start = 109000000;
			}else if(n >= 108500000){
			count = 27124997;start = 108500000;
			}else if(n >= 108000000){
			count = 26999998;start = 108000000;
			}else if(n >= 107500000){
			count = 26874999;start = 107500000;
			}else if(n >= 107000000){
			count = 26749996;start = 107000000;
			}else if(n >= 106500000){
			count = 26624997;start = 106500000;
			}else if(n >= 106000000){
			count = 26499997;start = 106000000;
			}else if(n >= 105500000){
			count = 26374998;start = 105500000;
			}else if(n >= 105000000){
			count = 26249997;start = 105000000;
			}else if(n >= 104500000){
			count = 26124997;start = 104500000;
			}else if(n >= 104000000){
			count = 25999998;start = 104000000;
			}else if(n >= 103500000){
			count = 25874996;start = 103500000;
			}else if(n >= 103000000){
			count = 25749997;start = 103000000;
			}else if(n >= 102500000){
			count = 25624998;start = 102500000;
			}else if(n >= 102000000){
			count = 25499998;start = 102000000;
			}else if(n >= 101500000){
			count = 25374997;start = 101500000;
			}else if(n >= 101000000){
			count = 25249997;start = 101000000;
			}else if(n >= 100500000){
			count = 25124998;start = 100500000;
			}else if(n >= 100000000){
			count = 24999999;start = 100000000;
			}else if(n >= 99500000){
			count = 24874997;start = 99500000;
			}else if(n >= 99000000){
			count = 24749998;start = 99000000;
			}else if(n >= 98500000){
			count = 24624998;start = 98500000;
			}else if(n >= 98000000){
			count = 24499998;start = 98000000;
			}else if(n >= 97500000){
			count = 24374996;start = 97500000;
			}else if(n >= 97000000){
			count = 24249996;start = 97000000;
			}else if(n >= 96500000){
			count = 24124997;start = 96500000;
			}else if(n >= 96000000){
			count = 23999996;start = 96000000;
			}else if(n >= 95500000){
			count = 23874996;start = 95500000;
			}else if(n >= 95000000){
			count = 23749997;start = 95000000;
			}else if(n >= 94500000){
			count = 23624996;start = 94500000;
			}else if(n >= 94000000){
			count = 23499997;start = 94000000;
			}else if(n >= 93500000){
			count = 23374996;start = 93500000;
			}else if(n >= 93000000){
			count = 23249997;start = 93000000;
			}else if(n >= 92500000){
			count = 23124997;start = 92500000;
			}else if(n >= 92000000){
			count = 22999997;start = 92000000;
			}else if(n >= 91500000){
			count = 22874997;start = 91500000;
			}else if(n >= 91000000){
			count = 22749996;start = 91000000;
			}else if(n >= 90500000){
			count = 22624997;start = 90500000;
			}else if(n >= 90000000){
			count = 22499998;start = 90000000;
			}else if(n >= 89500000){
			count = 22374997;start = 89500000;
			}else if(n >= 89000000){
			count = 22249997;start = 89000000;
			}else if(n >= 88500000){
			count = 22124997;start = 88500000;
			}else if(n >= 88000000){
			count = 21999998;start = 88000000;
			}else if(n >= 87500000){
			count = 21874997;start = 87500000;
			}else if(n >= 87000000){
			count = 21749996;start = 87000000;
			}else if(n >= 86500000){
			count = 21624997;start = 86500000;
			}else if(n >= 86000000){
			count = 21499997;start = 86000000;
			}else if(n >= 85500000){
			count = 21374996;start = 85500000;
			}else if(n >= 85000000){
			count = 21249997;start = 85000000;
			}else if(n >= 84500000){
			count = 21124997;start = 84500000;
			}else if(n >= 84000000){
			count = 20999998;start = 84000000;
			}else if(n >= 83500000){
			count = 20874996;start = 83500000;
			}else if(n >= 83000000){
			count = 20749997;start = 83000000;
			}else if(n >= 82500000){
			count = 20624998;start = 82500000;
			}else if(n >= 82000000){
			count = 20499996;start = 82000000;
			}else if(n >= 81500000){
			count = 20374997;start = 81500000;
			}else if(n >= 81000000){
			count = 20249997;start = 81000000;
			}else if(n >= 80500000){
			count = 20124998;start = 80500000;
			}else if(n >= 80000000){
			count = 19999997;start = 80000000;
			}else if(n >= 79500000){
			count = 19874997;start = 79500000;
			}else if(n >= 79000000){
			count = 19749998;start = 79000000;
			}else if(n >= 78500000){
			count = 19624997;start = 78500000;
			}else if(n >= 78000000){
			count = 19499996;start = 78000000;
			}else if(n >= 77500000){
			count = 19374997;start = 77500000;
			}else if(n >= 77000000){
			count = 19249997;start = 77000000;
			}else if(n >= 76500000){
			count = 19124997;start = 76500000;
			}else if(n >= 76000000){
			count = 18999996;start = 76000000;
			}else if(n >= 75500000){
			count = 18874997;start = 75500000;
			}else if(n >= 75000000){
			count = 18749998;start = 75000000;
			}else if(n >= 74500000){
			count = 18624997;start = 74500000;
			}else if(n >= 74000000){
			count = 18499997;start = 74000000;
			}else if(n >= 73500000){
			count = 18374997;start = 73500000;
			}else if(n >= 73000000){
			count = 18249997;start = 73000000;
			}else if(n >= 72500000){
			count = 18124998;start = 72500000;
			}else if(n >= 72000000){
			count = 17999997;start = 72000000;
			}else if(n >= 71500000){
			count = 17874998;start = 71500000;
			}else if(n >= 71000000){
			count = 17749997;start = 71000000;
			}else if(n >= 70500000){
			count = 17624998;start = 70500000;
			}else if(n >= 70000000){
			count = 17499998;start = 70000000;
			}else if(n >= 69500000){
			count = 17374997;start = 69500000;
			}else if(n >= 69000000){
			count = 17249998;start = 69000000;
			}else if(n >= 68500000){
			count = 17124998;start = 68500000;
			}else if(n >= 68000000){
			count = 16999997;start = 68000000;
			}else if(n >= 67500000){
			count = 16874997;start = 67500000;
			}else if(n >= 67000000){
			count = 16749997;start = 67000000;
			}else if(n >= 66500000){
			count = 16624998;start = 66500000;
			}else if(n >= 66000000){
			count = 16499996;start = 66000000;
			}else if(n >= 65500000){
			count = 16374997;start = 65500000;
			}else if(n >= 65000000){
			count = 16249998;start = 65000000;
			}else if(n >= 64500000){
			count = 16124998;start = 64500000;
			}else if(n >= 64000000){
			count = 15999997;start = 64000000;
			}else if(n >= 63500000){
			count = 15874997;start = 63500000;
			}else if(n >= 63000000){
			count = 15749998;start = 63000000;
			}else if(n >= 62500000){
			count = 15624999;start = 62500000;
			}else if(n >= 62000000){
			count = 15499997;start = 62000000;
			}else if(n >= 61500000){
			count = 15374998;start = 61500000;
			}else if(n >= 61000000){
			count = 15249998;start = 61000000;
			}else if(n >= 60500000){
			count = 15124997;start = 60500000;
			}else if(n >= 60000000){
			count = 14999998;start = 60000000;
			}else if(n >= 59500000){
			count = 14874998;start = 59500000;
			}else if(n >= 59000000){
			count = 14749999;start = 59000000;
			}else if(n >= 58500000){
			count = 14624996;start = 58500000;
			}else if(n >= 58000000){
			count = 14499997;start = 58000000;
			}else if(n >= 57500000){
			count = 14374998;start = 57500000;
			}else if(n >= 57000000){
			count = 14249997;start = 57000000;
			}else if(n >= 56500000){
			count = 14124997;start = 56500000;
			}else if(n >= 56000000){
			count = 13999997;start = 56000000;
			}else if(n >= 55500000){
			count = 13874998;start = 55500000;
			}else if(n >= 55000000){
			count = 13749998;start = 55000000;
			}else if(n >= 54500000){
			count = 13624997;start = 54500000;
			}else if(n >= 54000000){
			count = 13499998;start = 54000000;
			}else if(n >= 53500000){
			count = 13374997;start = 53500000;
			}else if(n >= 53000000){
			count = 13249998;start = 53000000;
			}else if(n >= 52500000){
			count = 13124998;start = 52500000;
			}else if(n >= 52000000){
			count = 12999998;start = 52000000;
			}else if(n >= 51500000){
			count = 12874998;start = 51500000;
			}else if(n >= 51000000){
			count = 12749998;start = 51000000;
			}else if(n >= 50500000){
			count = 12624998;start = 50500000;
			}else if(n >= 50000000){
			count = 12499999;start = 50000000;
			}else if(n >= 49500000){
			count = 12374998;start = 49500000;
			}else if(n >= 49000000){
			count = 12249999;start = 49000000;
			}else if(n >= 48500000){
			count = 12124996;start = 48500000;
			}else if(n >= 48000000){
			count = 11999996;start = 48000000;
			}else if(n >= 47500000){
			count = 11874997;start = 47500000;
			}else if(n >= 47000000){
			count = 11749997;start = 47000000;
			}else if(n >= 46500000){
			count = 11624997;start = 46500000;
			}else if(n >= 46000000){
			count = 11499996;start = 46000000;
			}else if(n >= 45500000){
			count = 11374997;start = 45500000;
			}else if(n >= 45000000){
			count = 11249998;start = 45000000;
			}else if(n >= 44500000){
			count = 11124996;start = 44500000;
			}else if(n >= 44000000){
			count = 10999997;start = 44000000;
			}else if(n >= 43500000){
			count = 10874997;start = 43500000;
			}else if(n >= 43000000){
			count = 10749998;start = 43000000;
			}else if(n >= 42500000){
			count = 10624997;start = 42500000;
			}else if(n >= 42000000){
			count = 10499997;start = 42000000;
			}else if(n >= 41500000){
			count = 10374998;start = 41500000;
			}else if(n >= 41000000){
			count = 10249996;start = 41000000;
			}else if(n >= 40500000){
			count = 10124997;start = 40500000;
			}else if(n >= 40000000){
			count = 9999998;start = 40000000;
			}else if(n >= 39500000){
			count = 9874998;start = 39500000;
			}else if(n >= 39000000){
			count = 9749996;start = 39000000;
			}else if(n >= 38500000){
			count = 9624996;start = 38500000;
			}else if(n >= 38000000){
			count = 9499997;start = 38000000;
			}else if(n >= 37500000){
			count = 9374998;start = 37500000;
			}else if(n >= 37000000){
			count = 9249996;start = 37000000;
			}else if(n >= 36500000){
			count = 9124997;start = 36500000;
			}else if(n >= 36000000){
			count = 8999997;start = 36000000;
			}else if(n >= 35500000){
			count = 8874997;start = 35500000;
			}else if(n >= 35000000){
			count = 8749997;start = 35000000;
			}else if(n >= 34500000){
			count = 8624997;start = 34500000;
			}else if(n >= 34000000){
			count = 8499998;start = 34000000;
			}else if(n >= 33500000){
			count = 8374997;start = 33500000;
			}else if(n >= 33000000){
			count = 8249997;start = 33000000;
			}else if(n >= 32500000){
			count = 8124998;start = 32500000;
			}else if(n >= 32000000){
			count = 7999997;start = 32000000;
			}else if(n >= 31500000){
			count = 7874998;start = 31500000;
			}else if(n >= 31000000){
			count = 7749997;start = 31000000;
			}else if(n >= 30500000){
			count = 7624998;start = 30500000;
			}else if(n >= 30000000){
			count = 7499998;start = 30000000;
			}else if(n >= 29500000){
			count = 7374998;start = 29500000;
			}else if(n >= 29000000){
			count = 7249997;start = 29000000;
			}else if(n >= 28500000){
			count = 7124996;start = 28500000;
			}else if(n >= 28000000){
			count = 6999997;start = 28000000;
			}else if(n >= 27500000){
			count = 6874998;start = 27500000;
			}else if(n >= 27000000){
			count = 6749997;start = 27000000;
			}else if(n >= 26500000){
			count = 6624997;start = 26500000;
			}else if(n >= 26000000){
			count = 6499997;start = 26000000;
			}else if(n >= 25500000){
			count = 6374998;start = 25500000;
			}else if(n >= 25000000){
			count = 6249998;start = 25000000;
			}else if(n >= 24500000){
			count = 6124997;start = 24500000;
			}else if(n >= 24000000){
			count = 5999998;start = 24000000;
			}else if(n >= 23500000){
			count = 5874998;start = 23500000;
			}else if(n >= 23000000){
			count = 5749997;start = 23000000;
			}else if(n >= 22500000){
			count = 5624998;start = 22500000;
			}else if(n >= 22000000){
			count = 5499998;start = 22000000;
			}else if(n >= 21500000){
			count = 5374999;start = 21500000;
			}else if(n >= 21000000){
			count = 5249997;start = 21000000;
			}else if(n >= 20500000){
			count = 5124998;start = 20500000;
			}else if(n >= 20000000){
			count = 4999999;start = 20000000;
			}else if(n >= 19500000){
			count = 4874996;start = 19500000;
			}else if(n >= 19000000){
			count = 4749997;start = 19000000;
			}else if(n >= 18500000){
			count = 4624997;start = 18500000;
			}else if(n >= 18000000){
			count = 4499998;start = 18000000;
			}else if(n >= 17500000){
			count = 4374997;start = 17500000;
			}else if(n >= 17000000){
			count = 4249997;start = 17000000;
			}else if(n >= 16500000){
			count = 4124998;start = 16500000;
			}else if(n >= 16000000){
			count = 3999997;start = 16000000;
			}else if(n >= 15500000){
			count = 3874997;start = 15500000;
			}else if(n >= 15000000){
			count = 3749998;start = 15000000;
			}else if(n >= 14500000){
			count = 3624998;start = 14500000;
			}else if(n >= 14000000){
			count = 3499998;start = 14000000;
			}else if(n >= 13500000){
			count = 3374997;start = 13500000;
			}else if(n >= 13000000){
			count = 3249998;start = 13000000;
			}else if(n >= 12500000){
			count = 3124999;start = 12500000;
			}else if(n >= 12000000){
			count = 2999998;start = 12000000;
			}else if(n >= 11500000){
			count = 2874998;start = 11500000;
			}else if(n >= 11000000){
			count = 2749998;start = 11000000;
			}else if(n >= 10500000){
			count = 2624998;start = 10500000;
			}else if(n >= 10000000){
			count = 2499999;start = 10000000;
			}else if(n >= 9500000){
			count = 2374997;start = 9500000;
			}else if(n >= 9000000){
			count = 2249998;start = 9000000;
			}else if(n >= 8500000){
			count = 2124997;start = 8500000;
			}else if(n >= 8000000){
			count = 1999998;start = 8000000;
			}else if(n >= 7500000){
			count = 1874998;start = 7500000;
			}else if(n >= 7000000){
			count = 1749997;start = 7000000;
			}else if(n >= 6500000){
			count = 1624998;start = 6500000;
			}else if(n >= 6000000){
			count = 1499998;start = 6000000;
			}else if(n >= 5500000){
			count = 1374998;start = 5500000;
			}else if(n >= 5000000){
			count = 1249998;start = 5000000;
			}else if(n >= 4500000){
			count = 1124998;start = 4500000;
			}else if(n >= 4000000){
			count = 999999;start = 4000000;
			}else if(n >= 3500000){
			count = 874997;start = 3500000;
			}else if(n >= 3000000){
			count = 749998;start = 3000000;
			}else if(n >= 2500000){
			count = 624999;start = 2500000;
			}else if(n >= 2000000){
			count = 499999;start = 2000000;
			}else if(n >= 1500000){
			count = 374998;start = 1500000;
			}else if(n >= 1000000){
			count = 249998;start = 1000000;
			}else if(n >= 500000){
			count = 124999;start = 500000;
			}
		for (long i = start + 5; i <= n; i+=5) {
			count += number(i);
		}
		return count;
	}
	
	public static int number(long i) {
		int sum = 0;
		while(i % 5 == 0) {
			sum++;
			i = i / 5;
		}
		return sum;
	}

}
