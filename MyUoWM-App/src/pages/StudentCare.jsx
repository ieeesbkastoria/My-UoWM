import React from 'react';
import { Flex, Box, Text, Button, useColorModeValue } from "@chakra-ui/react";
import i18n from "../i18n";

function StudentCarePage() {
  const containerStyle = {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    justifyContent: 'center',
    // height: '100vh',
    width: '100%',
  };

  const boxStyle = {
    backgroundColor: 'white',
    border: '1px solid #ccc',
    padding: '20px',
    marginBottom: '20px',
    zIndex: 10,
  };

  const categories = [
    "Myfeo",
    "OlistikhMerimna",
    "MedicalCare",
    "Sitish",
    "Stegash",
    "FoithtikoEpidoma",
    "EuroCardAsfalish",
  ];


  return (
    <div style={containerStyle}>
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
          width="80%"
          height="10%"
        >
          <Flex
            mx="1rem"
            alignItems="center"
            rowGap={"0.75rem"}
            justifyContent={"center"}
            columnGap={"1rem"}
            color={useColorModeValue("#f3f3f3", "black")}
            fontFamily="Syne"
            w="100%"
            fontSize={{ base: "md", lg: "2xl" }}
          > {i18n.t("StudentCare")}
          <br></br>
            {i18n.t("StudentCare2")}
          </Flex>

        </Box>
        
    </div>
    
  );
}

export default StudentCarePage;



