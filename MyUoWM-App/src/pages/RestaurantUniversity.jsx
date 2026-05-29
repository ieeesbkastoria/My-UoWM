import React from "react";
import {
  Flex,
  Box,
  Text,
  useColorModeValue,
} from "@chakra-ui/react";
import { TimeIcon } from "@chakra-ui/icons";
import { useTranslation } from "react-i18next";
import i18n from "../i18n";
import { menu } from "../assets/data/restaurantMenu";
import { dayKeys, greekDays, englishDays } from "../utils/days";
import { getPreviousWeekKey } from "../utils/date";
import { colors } from "../theme/theme";

export default function RestaurantUniversity() {
  const { t } = useTranslation();
  React.useEffect(() => {
    window.scrollTo(0, 0);
  }, []);

  const weekKey = getPreviousWeekKey();
  const dayKey = dayKeys[new Date().getDay()];
  const todayMenu = menu[weekKey][dayKey];
  const lang = i18n.language === "el" ? "gr" : "en";
  const dayLabel = lang === "gr" ? greekDays[dayKey] : englishDays[dayKey];

  return (
    <Flex
      w="100vw"
      overflowX="hidden"
      flexDirection="column"
      alignItems="center"
    >
      {/*Wrapper container*/}
      <Flex
        textAlign="center"
        flexDirection="column"
        rowGap="1.5rem"
        alignItems="center"
        justifyContent="center"
        width={{ sm: "100%", lg: "fit-content" }}
        paddingX="16px"
        margin={{ sm: "1rem", lg: "5rem 0 10rem 0" }}
      >

        {/*Menu Ημερας*/}
        <Box
          border="2px"
          borderRadius="1rem"
          borderColor={useColorModeValue(colors.primary, colors.lightBg)}
          bg={useColorModeValue(colors.primary, colors.lightBg)}
          px="1.5rem"
          py="1.5rem"
          width="100%"
          marginTop={{ base: "1rem", lg: "0" }}
        >
          <Flex
            flexDirection="column"
            alignItems="center"
            color={useColorModeValue(colors.lightBg, "black")}
            fontFamily="Syne"
          >
            <Box mt="1rem" w="100%">
              <Text
                fontSize={{ base: "xl", lg: "3xl" }}
                fontWeight="bold"
                mb="0.25rem"
              >
                {t("restaurantTitle")}
              </Text>
              <Text
                fontSize={{ base: "md", lg: "lg" }}
                fontWeight="semibold"
                mt="0.25rem"
              >
                {t("today")}: {dayLabel}
              </Text>
            </Box>
          </Flex>
        </Box>

        {/*Πρωινό*/}
        <Box
          border="2px"
          borderRadius="1rem"
          borderColor={useColorModeValue(colors.primary, colors.lightBg)}
          bg={useColorModeValue(colors.primary, colors.lightBg)}
          px="1.5rem"
          py="1.5rem"
          width="100%"
          marginTop={{ base: "1rem", lg: "0" }}
        >
          <Flex
            flexDirection="column"
            alignItems="center"
            color={useColorModeValue(colors.lightBg, "black")}
            fontFamily="Syne"
          >
            <Flex alignItems="center">
              <Text ml="1rem" fontSize={{ base: "lg", lg: "2xl" }} fontWeight="bold">
                {t("breakfast")}
              </Text>
            </Flex>
            <Text mt="0.5rem">
              <b>{t("drinks")}: </b>{menu.breakfast.drinks[lang].join(", ")}
            </Text>
            <Text mt="0.5rem">
              <b>{t("breads")}: </b>{menu.breakfast.breads[lang].join(", ")}
            </Text>
            <Text mt="0.5rem">
              <b>{t("spreads")}: </b>{menu.breakfast.spreads[lang].join(", ")}
            </Text>
            <Text mt="0.5rem">
              <b>{t("staples")}: </b>{menu.breakfast.staples[lang].join(", ")}
            </Text>
          </Flex>
        </Box>

            {/*Μεσημεριανό*/}
        <Box
          border="2px"
          borderRadius="1rem"
          borderColor={useColorModeValue(colors.primary, colors.lightBg)}
          bg={useColorModeValue(colors.primary, colors.lightBg)}
          px="1.5rem"
          py="1.5rem"
          width="100%"
          marginTop={{ base: "1rem", lg: "0" }}
        >
          <Flex
            flexDirection="column"
            alignItems="center"
            color={useColorModeValue(colors.lightBg, "black")}
            fontFamily="Syne"
          >
            <Flex alignItems="center">
              <Text ml="1rem" fontSize={{ base: "lg", lg: "2xl" }} fontWeight="bold">
                {t("lunch")}
              </Text>
            </Flex>
            <Text mt="0.5rem">
              <b>{t("firstCourse")}:</b> {todayMenu.lunch.first[lang].join(", ")}
            </Text>
            <Text mt="0.25rem" whiteSpace="pre-line">
              <b>{t("mainCourse")}:</b>
              {"\n"}
              {todayMenu.lunch.main[lang].join(",\n")}
            </Text>
            <Text mt="0.25rem">
              <b>{t("extra")}:</b> {todayMenu.lunchExtra[lang].join(", ")}
            </Text>
          </Flex>
        </Box>

        {/*Άπογευματινο*/}
        <Box
          border="2px"
          borderRadius="1rem"
          borderColor={useColorModeValue(colors.primary, colors.lightBg)}
          bg={useColorModeValue(colors.primary, colors.lightBg)}
          px="1.5rem"
          py="1.5rem"
          width="100%"
          marginTop={{ base: "1rem", lg: "0" }}
        >
          <Flex
            flexDirection="column"
            alignItems="center"
            color={useColorModeValue(colors.lightBg, "black")}
            fontFamily="Syne"
          >
            <Flex alignItems="center">
              <Text ml="1rem" fontSize={{ base: "lg", lg: "2xl" }} fontWeight="bold">
                {t("dinner")}
              </Text>
            </Flex>
            <Text mt="0.5rem">
              <b>{t("firstCourse")}:</b> {todayMenu.dinner.first[lang].join(", ")}
            </Text>
            <Text mt="0.25rem" whiteSpace="pre-line">
              <b>{t("mainCourse")}:</b>
              {"\n"}
              {todayMenu.dinner.main[lang].join(",\n")}
            </Text>
            <Text mt="0.25rem">
              <b>{t("extra")}:</b> {todayMenu.dinnerExtra[lang].join(", ")}
            </Text>
          </Flex>
        </Box>

        {/*Ωραριο*/}
        <Box
          border="2px"
          borderRadius="1rem"
          bg={useColorModeValue(colors.primary, colors.lightBg)}
          borderColor={useColorModeValue(colors.primary, colors.lightBg)}
          px="1.5rem"
          py="1.5rem"
          width="100%"
          display="flex"
          justifyContent="center"
          alignItems="center"
        >
          <Flex
            flexDirection="column"
            alignItems="center"
            fontFamily="Syne"
            w="100%"
            fontSize={{ base: "md", lg: "xl" }}
            color={useColorModeValue(colors.lightBg, "black")}
          >
            <Flex alignItems="center">
              <TimeIcon w={30} h={30} />
              <Text ml="1rem" fontSize={{ base: "lg", lg: "2xl" }} fontWeight="bold">
                {t("orario")}
              </Text>
            </Flex>

            <Flex mt="1rem">
              <Text fontWeight="bold" mr="0.5rem">
                {t("breakfast")}:
              </Text>
              <Text>7:00 – 9:00</Text>
            </Flex>
            <Flex mt="0.5rem">
              <Text fontWeight="bold" mr="0.5rem">
                {t("lunch")}:
              </Text>
              <Text>12:00 – 15:30</Text>
            </Flex>
            <Flex mt="0.5rem">
              <Text fontWeight="bold" mr="0.5rem">
                {t("dinner")}:
              </Text>
              <Text>18:00 – 21:00</Text>
            </Flex>
          </Flex>
        </Box>
      </Flex>
    </Flex>
  );
}
