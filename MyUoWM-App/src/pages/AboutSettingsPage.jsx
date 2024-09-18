/*
  MIT License

  Copyright (c) 2022 Open Source  UOM

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

import {
  Accordion,
  AccordionItem,
  AccordionButton,
  AccordionIcon,
  AccordionPanel,
  Box,
  Button,
  Flex,
  HStack,
  Icon,
  Image,
  Stack,
  Text,
  VStack,
  useColorModeValue,
  Grid,
} from "@chakra-ui/react";
import membersData from "../assets/data/projectMembers";
import UoWMMembers from "../assets/UoWMMembers";
import ProjectMembersList from "../components/ProjectMembersList";
import { motion } from "framer-motion";
import { SocialIcon } from "react-social-icons";
import {
  Modal,
  ModalOverlay,
  ModalContent,
  ModalHeader,
  ModalBody,
  ModalCloseButton,
} from "@chakra-ui/react";

function AboutSettingsPage() {
  const SelectBorderColor = () => {
    return useColorModeValue("primary", "light");
  };

  const SelectItemColor = () => {
    return useColorModeValue("black", "white");
  };

  return (
    <Box
      align="center"
      marginTop="1em"
      fontSize={{ sm: 11.95, md: 16, lg: 26, xl: 32 }}
    >
      <Image src={"UoWM.png"} width="100px" height="100px" />
      <Text marginTop="1em" fontSize={{ sm: 26, md: 30, lg: 34, xl: 38 }}>
        myCS.uowm
        <br />
        Έκδοση v1.0.0
        <br />
        <br />
      </Text>
      <Accordion allowToggle="true" mt="1rem">
        <Flex
          w={{ sm: "90%", md: "75%", lg: "50%" }}
          direction="row"
          align="center"
          justify="start"
        >
          <Grid
            w="100%"
            as={motion.section}
            initial="initial"
            animate="inView"
            gap={{ sm: "1.5rem", lg: "2.5rem" }}
            templateRows={{ sm: "1fr" }}
          >
            <ProjectMembersList
              heading="Η ομάδα ανάπτυξης του myUoM"
              membersList={membersData}
            />
            <ProjectMembersList
              heading="Η ομάδα ανάπτυξης του myCS.uowm"
              membersList={UoWMMembers}
            />
          </Grid>
        </Flex>
      </Accordion>
    </Box>
  );
}

export default AboutSettingsPage;
