/*
  MIT License

  Copyright (c) 2024 Open Source  UOM

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in all
  copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  SOFTWARE.

  Made by Open Source UoM (https://opensource.uom.gr)

  Project members:
    -Apostolidis
    -Davios
    -Iosifidis
    -Konstantinidis
    -Mpakalis
    -Nasis
    -Omiliades
    -Patsouras
    -Fakidis

*/
import React from 'react';
import { Flex, Box, Text, Button, useColorModeValue } from "@chakra-ui/react";
import { useEffect, useState } from "react";
import MapCords from "../components/maps/MapCords";
import SelectBuildingDropdown from "../components/maps/SelectBuildingDropdown.jsx";
import SelectOfficeDropdown from "../components/maps/SelectOfficeDropdown.jsx";
import { useDepName, useMapData } from "../hooks";
import i18n from "../i18n";

function MapPage() {
  const containerStyle = {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    justifyContent: 'center',
    height: '100vh',
    width: '100%',
  };

  const boxStyle = {
    backgroundColor: 'white',
    border: '1px solid #ccc',
    padding: '20px',
    marginBottom: '20px',
    zIndex: 10,
  };



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
          width="100%"
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
          > {i18n.t("MapInfo")}
          </Flex>
        </Box>
      <iframe src="https://www.google.com/maps/d/u/0/embed?mid=1xjlab_NeXx0zko8xr77Garj0bVh7p-A&ehbc=2E312F&noprof=1" 
      width="80%" 
      height="1000vh"
      ></iframe>
    </div>
  );
}

export default MapPage;
