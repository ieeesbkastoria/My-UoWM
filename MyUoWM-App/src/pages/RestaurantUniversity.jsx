import { Flex, Box, Text, Button, useColorModeValue, Table, Thead, Tbody, Tr, Th, Td } from "@chakra-ui/react";
import i18n from "../i18n";
import MealIcon from "../assets/icons/MealIcon";

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
        justifyContent="center"
        width="100%"
        paddingX="16px"
      >
        {/* Blue Container */}
        <Box
          border="2px"
          borderRadius="1rem"
          borderColor={useColorModeValue("#00ABC1", "#f3f3f3")}
          bg={useColorModeValue("#00ABC1", "#f3f3f3")}
          display="flex"
          flexDirection="column"
          justifyContent="center"
          alignItems="center"
          py="1rem"
          px="0.75rem"
          width={{ base: "100%", lg: "50%" }}  
          maxWidth="100%"  
          boxSizing="border-box"
          overflowX="hidden"  
        >
          <Flex
            flexDirection="column"
            alignItems="flex-start"
            justifyContent="flex-start"
            color={useColorModeValue("#f3f3f3", "black")}
            fontFamily="Syne"
            w="100%"
            fontSize={{ base: "md", lg: "2xl" }}
          >
            {/* Contact Information */}
            <Flex flexDirection="row" alignItems="center">
              <Text 
                fontSize={{ base: "lg", lg: "1xl" }}
                ml="1rem"
                as="span"
                fontWeight="bold"
              >
                {i18n.t("RestaurantInfo")}
              </Text>
            </Flex>
          </Flex>

          {/* Meal Timings Table */}
          <Box
            mt="2rem"
            w="100%"
            p={2}
            borderWidth="1px"
            borderRadius="lg"
            overflow="hidden"
            bg={useColorModeValue("#f3f3f3", "#00ABC1")}
          >
            <Table variant="simple">
              <Thead>
                <Tr>
                  <Th color={useColorModeValue("#00ABC1", "#f3f3f3")} textAlign="center">
                    {i18n.t("mealType")}
                  </Th>
                  <Th color={useColorModeValue("#00ABC1", "#f3f3f3")} textAlign="center">
                    {i18n.t("timeServed")}
                  </Th>
                </Tr>
              </Thead>
              <Tbody>
                <Tr>
                  <Td textAlign="center">{i18n.t("breakfast")}</Td>
                  <Td textAlign="center">08:00 - 09:30 </Td>
                </Tr>
                <Tr>
                  <Td textAlign="center">{i18n.t("lunch")}</Td>
                  <Td textAlign="center">12:00 - 15:30</Td>
                </Tr>
                <Tr>
                  <Td textAlign="center">{i18n.t("dinner")}</Td>
                  <Td textAlign="center">18:00 - 21:00</Td>
                </Tr>
              </Tbody>
            </Table>
          </Box>
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
        mt="2rem"
      >
        {i18n.t("restaurantPage")}
      </Button>
    </Flex>
  );
}
