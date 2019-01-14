package com.example.daniel.engineersuniversalconverter;

public class VolumeConverter {
    public static double volumeConversion(double original, String convertFrom, String convertTo) {
        double convertedVolume = original;
        double metresCubed = original;
        switch (convertFrom) {
            case "Cubic Centimetres":
                metresCubed = cmToM(original);
                break;

            case "Cubic Millimetres":
                metresCubed = mmToM(original);
                break;

            case "Litres":
                metresCubed = litresToM(original);
                break;

            case "US Gallons":
                metresCubed = gallonsToM(original);
                break;

            case "Fluid Ounces":
                metresCubed = ouncesToM(original);
                break;
        }

        switch (convertTo) {
            case "Cubic Centimetres":
                convertedVolume = mToCM(metresCubed);
                break;

            case "Cubic Millimetres":
                convertedVolume = mToMM(metresCubed);
                break;

            case "Litres":
                convertedVolume = mToLitres(metresCubed);
                break;

            case "US Gallons":
                convertedVolume = mToGallons(metresCubed);
                break;

            case "Fluid Ounces":
                convertedVolume = mToOunces(metresCubed);
                break;
        }
        return convertedVolume;
    }

    private static double cmToM(double CM) {
        return CM/1000000;
    }

    private static double mmToM(double MM) {
        return MM/1000000000;
    }

    private static double litresToM(double litres) {
        return litres/1000;
    }

    private static double gallonsToM(double gallons) {
        return gallons/264.172;
    }

    private static double ouncesToM(double ounces) {
        return ounces/33814.023;
    }

    private static double mToCM(double metres) {
        return metres*1000000;
    }

    private static double mToMM(double metres) {
        return metres*1000000000;
    }

    private static double mToLitres(double metres) {
        return metres*1000;
    }

    private static double mToGallons(double metres) {
        return metres*264.172;
    }

    private static double mToOunces(double metres) {
        return metres*33814.023;
    }
}
