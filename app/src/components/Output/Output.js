import React from 'react'
import { Segment } from 'semantic-ui-react';

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
                        ? JSON.stringify(response)
                        : ''
                }
            </div>
        </Segment>
    )
}

export default Output
