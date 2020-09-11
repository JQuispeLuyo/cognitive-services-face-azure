import React from 'react'
import { Segment, Table } from 'semantic-ui-react';

const Output = ({ response, error }) => {

    return (
        <Segment stacked>
            <div>
                {
                    error.message
                        ? `Ocurrio un error: ${error.message}`
                        : ''
                }
                {
                    response.length > 0
                        ? (
                            <Table basic='very' celled collapsing>
                                <Table.Header>
                                    <Table.Row>
                                        <Table.HeaderCell>Smile</Table.HeaderCell>
                                        <Table.HeaderCell>Gender</Table.HeaderCell>
                                        <Table.HeaderCell>Age</Table.HeaderCell>
                                        <Table.HeaderCell>Glasses</Table.HeaderCell>
                                        <Table.HeaderCell colSpan='2'>Emotion</Table.HeaderCell>
                                    </Table.Row>
                                </Table.Header>

                                <Table.Body>
                                    {
                                        response.map((x) => {
                                            return (
                                                <Table.Row key={x.faceId}>
                                                    <Table.Cell>{x.faceAttributes.smile}</Table.Cell>
                                                    <Table.Cell>{x.faceAttributes.gender}</Table.Cell>
                                                    <Table.Cell>{x.faceAttributes.age}</Table.Cell>
                                                    <Table.Cell>{x.faceAttributes.glasses}</Table.Cell>
                                                    <Table.Cell>

                                                        {`anger: ${x.faceAttributes.emotion.anger} 
                                                         contempt: ${x.faceAttributes.emotion.contempt} `}
                                                        <br />
                                                        {`disgust: ${x.faceAttributes.emotion.disgust}
                                                        fear: ${x.faceAttributes.emotion.fear} `}


                                                    </Table.Cell>
                                                    <Table.Cell>
                                                        {`happiness: ${x.faceAttributes.emotion.happiness}  
                                                        neutral: ${x.faceAttributes.emotion.neutral} `}
                                                        <br />
                                                        {`sadness: ${x.faceAttributes.emotion.sadness} 
                                                        surprise: ${x.faceAttributes.emotion.surprise}`}
                                                    </Table.Cell>
                                                </Table.Row>
                                            )
                                        }
                                        )
                                    }

                                </Table.Body>
                            </Table>
                        )
                        : ''
                }
            </div>
        </Segment>
    )
}

export default Output
