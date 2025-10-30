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
import React, { useState } from 'react'
import {
    Flex,
    Box,
    useColorModeValue,
    Button,
    Wrap,
    WrapItem,
} from '@chakra-ui/react'
import i18n from '../i18n'

const url_ =
    'https://www.google.com/maps/d/u/0/embed?mid=10Rr6Rl9MIkY6KP1kgp9NxzbpNRjoU3I&ehbc=2E312F'

const mapViews = {
    campus: {
        name: 'Campus',
        url: 'https://www.google.com/maps/d/u/0/embed?mid=10Rr6Rl9MIkY6KP1kgp9NxzbpNRjoU3I&ehbc=2E312F&noprof=1', // <-- REPLACE
    },
    buildingA: {
        name: 'Building A',
        url: 'https://www.google.com/maps/d/u/0/embed?mid=1abMH79xkBfCSJ_WQGjAFDeXP1foImbY&ehbc=2E312F&noprof=1', // <-- REPLACE
    },
    buildingB: {
        name: 'Building B',
        url: url_, // <-- REPLACE
    },
    buildingC: {
        name: 'Building C',
        url: 'https://www.google.com/maps/d/u/0/embed?mid=1S5VfJpXanemEuCwXyWpy2k_v8J5IB_Q&ehbc=2E312F&noprof=1', // <-- REPLACE
    },
    busStops: {
        name: 'Bus Stops',
        url: url_, // <-- REPLACE
    },
}
// -------------------

function MapPage() {
    const containerStyle = {
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center',
        height: '100vh',
        width: '100%',
    }

    // State to hold the current map URL. Initialize it with the "All Locations" view.
    const [currentMapUrl, setCurrentMapUrl] = useState(mapViews.campus.url)
    // -------------------

    React.useEffect(() => {
        window.scrollTo(0, 0)
    }, [])

    const bgColor = useColorModeValue('#00ABC1', '#f3f3f3')
    const borderColor = useColorModeValue('#00ABC1', '#f3f3f3')
    const textColor = useColorModeValue('#f3f3f3', 'black')
    const buttonColorScheme = useColorModeValue('teal', 'gray')

    return (
        <div style={containerStyle}>
            <Box
                border="2px"
                borderRadius="1rem"
                borderColor={borderColor}
                bg={bgColor}
                marginBottom={{ base: '1rem', lg: '0' }}
                marginTop="1rem"
                display={'flex'}
                justifyContent={'center'}
                alignItems={'center'}
                py="1rem"
                px="0.75rem"
                width="90%"
                height="auto"
            >
                <Flex
                    mx="1rem"
                    alignItems="center"
                    rowGap={'0.75rem'}
                    justifyContent={'center'}
                    columnGap={'1rem'}
                    color={textColor}
                    fontFamily="Syne"
                    w="100%"
                    fontSize={{ base: 'md', lg: '2xl' }}
                >
                    {' '}
                    {i18n.t('MapInfo')}
                </Flex>
            </Box>

            {/* Buttons for toggling --- */}
            <Box width="80%" my="1rem">
                <Wrap spacing="10px" justify="center">
                    {Object.values(mapViews).map((view) => (
                        <WrapItem key={view.name}>
                            <Button
                                colorScheme={buttonColorScheme}
                                onClick={() => setCurrentMapUrl(view.url)}
                            >
                                {view.name}
                            </Button>
                        </WrapItem>
                    ))}
                </Wrap>
            </Box>
            {/* ------------------------------------------- */}

            <iframe
                src={currentMapUrl}
                width="80%"
                height="100%"
                title="Map of Kastoria"
                style={{ border: 0 }} // Recommended by Google
            ></iframe>
            {/* ------------------------ */}
        </div>
    )
}

export default MapPage
