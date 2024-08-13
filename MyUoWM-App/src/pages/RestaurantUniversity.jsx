import { Flex, Box, Text, Button, useColorModeValue } from "@chakra-ui/react";
import i18n from "../i18n";
import { TimeIcon, PhoneIcon } from "@chakra-ui/icons";

export default function RestaurantUniversity() {
  return (
    <Flex
      w="100vw"
      overflowX="hidden"
      flexDirection="column"
      alignItems="center"
    >
      {/* Wrapper container */}
      <Flex
        textAlign="center"
        flexDirection={{ base: "column", lg: "row" }}
        columnGap={"3rem"}
        alignItems="center"
        justifyContent={"center"}
        width={{ sm: "100%", lg: "fit-content" }}
        height={{ lg: "75vh" }}
        paddingX="16px"
      >
        {/* Επικοινωνία  */}
        <Box
          border="2px"
          borderRadius="1rem"
          borderColor={useColorModeValue("#00ABC1", "#f3f3f3")}
          bg={useColorModeValue("#00ABC1", "#f3f3f3")}
          marginBottom={{ base: "1rem", lg: "0" }}
          marginTop="1rem"
          display={"flex"}
          justifyContent={"center"}
          alignItems={"center"}
          py="1rem"
          px="0.75rem"
          width="100%"
          height={{ lg: "30%" }}
        >
          <Flex
            mx="1rem"
            flexDirection={"column"}
            alignItems="flex-start"
            rowGap={"0.75rem"}
            justifyContent={"flex-start"}
            columnGap={"1rem"}
            color={useColorModeValue("#f3f3f3", "black")}
            fontFamily="Syne"
            w="100%"
            fontSize={{ base: "md", lg: "2xl" }}
          >
            <Flex flexDirection={"row"} alignItems="center">
              <PhoneIcon w={27} h={27} />
              <Text
                fontSize={{ base: "lg", lg: "2xl" }}
                ml="1rem"
                as="span"
                fontWeight={"bold"}
              >
                {i18n.t("epikoinonia")}
              </Text>
            </Flex>

            <Flex
              flexDirection={"row"}
              alignItems="center"
              justifyContent="space-between"
              w="100%"
              gap="2rem"
            >
            </Flex>
          </Flex>
        </Box>
      </Flex>
      <Button
        color={useColorModeValue("#00ABC1", "#f3f3f3")}
        variant="ghost"
        fontWeight="bold"
        fontFamily="Syne"
        fontSize={{ base: "lg", lg: "2xl" }}
        rightIcon={
          <Box ml="0.5rem">
            <svg
              width="15px"
              viewBox="0 0 10 10"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M0.873535 9L8.91951 1"
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={1.5}
                stroke={useColorModeValue("#00ABC1", "#f3f3f3")}
              />
              <path
                d="M0.873535 1H8.91951V9"
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={1.5}
                stroke={useColorModeValue("#00ABC1", "#f3f3f3")}
              />
            </svg>
          </Box>
        }
        onClick={(e) => {
          window.open("https://www.uowm.gr/epikairotita/sitisi/enimerosi-gia-tin-leitoyrgia-ton-estiatorion-toy-panepistimioy-dytikis-makedonias-2024/");
        }}
        justifyContent="center"
      >
        {i18n.t("istoselidaVivliothikis")} {/*να μπει το ονομα Ελληνικά και Αγγλικά*/}
      </Button>
      
    </Flex>
);
}
