import express from 'express'
const app = express()
import handlebars from 'express-handlebars'
import Handlebars from 'handlebars'
import { allowInsecurePrototypeAccess } from '@handlebars/allow-prototype-access'

app.engine('handlebars', handlebars.engine({
    defaultLayout: 'index',
    handlebars: allowInsecurePrototypeAccess(Handlebars)
}))
app.set('view engine', 'handlebars')

app.get('/',(req, res)=>{
    res.render('exemplo')
})

app.listen(3000,()=>{
    console.log('servidor rodando em http://localhost:3000')
})