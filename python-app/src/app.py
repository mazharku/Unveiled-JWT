from src.jose.encoded_jwt_token_util import EncodedJWTTokenUtil
from src.jose.jwt_util import JWTUtil
from src.pyjwt.py_jwt_util import PyJWTUtil

if __name__ == '__main__':
    secret = "ABCdfKLgABCdfKL"
    token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJlbmNvZGVkX2p3dF90b2tlbiIsImF1dGgiOiJqd3QiLCJ0eXBlIjoic3RhdGVsZXNzIiwiZXhwIjoxNzA2Mjk3NDA4LCJpYXQiOjE3MDYyOTY4MDh9.6F14n2Eg2vGuEg6T4xDKOwobqiIGUluPF0kfKbjYaiJCoUnUH3N-t5iyzGrXJObBBCbaEveJ8cPzjkUcEp7PZg"
    jwt_util = JWTUtil(secret)
    encode_jwt_util = EncodedJWTTokenUtil(secret)
    py_jwt = PyJWTUtil(secret)
    py_jwt.validate_token(token)
    #jwt_util.validate_token(token)
    #encode_jwt_util.validate_token(token)
