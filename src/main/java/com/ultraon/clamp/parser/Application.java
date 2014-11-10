package com.ultraon.clamp.parser;

/**
 * Created by vitaliypopov on 10.11.14.
 */
public class Application {
//    private static final String TMP = ",,878.934,885.314275590551,891.694551181102,898.074826771654,904.455102362205,910.835377952756,917.215653543307,923.595929133858,929.976204724409,936.356480314961,942.736755905512,949.117031496063,955.497307086614,961.877582677165,968.257858267717,974.638133858268,981.018409448819,987.39868503937,993.778960629921,1000.15923622047,1006.53951181102,1012.91978740157,1019.30006299213,1025.68033858268,1032.06061417323,1038.44088976378,1044.82116535433,1051.20144094488,1057.58171653543,1063.96199212598,1070.34226771654,1076.72254330709,1083.10281889764,1089.48309448819,1095.86337007874,1102.24364566929,1108.62392125984,1115.00419685039,1121.38447244094,1127.7647480315,1134.14502362205,1140.5252992126,1146.90557480315,1153.2858503937,1159.66612598425,1166.0464015748,1172.42667716535,1178.80695275591,1185.18722834646,1191.56750393701,1197.94777952756,1204.32805511811,1210.70833070866,1217.08860629921,1223.46888188976,1229.84915748031,1236.22943307087,1242.60970866142,1248.98998425197,1255.37025984252,1261.75053543307,1268.13081102362,1274.51108661417,1280.89136220472,1287.27163779528,1293.65191338583,1300.03218897638,1306.41246456693,1312.79274015748,1319.17301574803,1325.55329133858,1331.93356692913,1338.31384251969,1344.69411811024,1351.07439370079,1357.45466929134,1363.83494488189,1370.21522047244,1376.59549606299,1382.97577165354,1389.35604724409,1395.73632283465,1402.1165984252,1408.49687401575,1414.8771496063,1421.25742519685,1427.6377007874,1434.01797637795,1440.3982519685,1446.77852755905,1453.15880314961,1459.53907874016,1465.91935433071,1472.29962992126,1478.67990551181,1485.06018110236,1491.44045669291,1497.82073228346,1504.20100787402,1510.58128346457,1516.96155905512,1523.34183464567,1529.72211023622,1536.10238582677,1542.48266141732,1548.86293700787,1555.24321259843,1561.62348818898,1568.00376377953,1574.38403937008,1580.76431496063,1587.14459055118,1593.52486614173,1599.90514173228,1606.28541732283,1612.66569291339,1619.04596850394,1625.42624409449,1631.80651968504,1638.18679527559,1644.56707086614,1650.94734645669,1657.32762204724,1663.7078976378,1670.08817322835,1676.4684488189,1682.84872440945,1689.229,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,";

    public static void main(String[] args) {
//        System.out.println("length: " + TMP.split(",").length);

        System.out.println("args: " + args[0]);

        if (args.length == 0 || !FileUtils.isExistFile(args[0])) {
            System.out.println("Input clamp xml file path to the first arg");
            System.exit(1);
        }

        try {
            new ParseEngine(args[0]).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
