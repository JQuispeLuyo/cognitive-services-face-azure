import React, { useState } from 'react'
import { Button, Form, Segment } from 'semantic-ui-react';

const FormFace = ({ handleSubmit, loading }) => {

    const [value, setvalue] = useState({ file: null });

    const handleChange = ({ target }) => {
        setvalue({ [target.name]: URL.createObjectURL(target.files[0]) })
        console.log(value);
    }

    return (
        <Form size='large' onSubmit={handleSubmit} encType="multipart/form-data" >
            <Segment stacked>
                {
                    value.file
                        ? <img
                            src={value.file}
                            alt={`Face`}
                            style={{ maxWidth: 250 }}
                        />
                        : ''
                }
               <hr/> 
                {
                    loading
                        ? 'Loading...'
                        :
                        <div>
                            <Form.Input
                                type="file"
                                name="file"
                                fluid icon='photo'
                                iconPosition='left'
                                placeholder='Url...'
                                onChange={handleChange}
                            />
                            <Button
                                color='teal'
                                fluid size='large'
                            >
                                Enviar
                            </Button>
                        </div>
                }
            </Segment>
        </Form>
    )
}

export default FormFace
