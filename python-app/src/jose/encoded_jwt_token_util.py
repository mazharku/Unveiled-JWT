from jose import jwt
import base64


class EncodedJWTTokenUtil:

    def __init__(self, secret: str):
        self.secret = secret

    def validate_token(self, token: str):
        try:
            decoded_string = base64.urlsafe_b64decode(self.secret)
            jwt.decode(
                token=token, key=decoded_string, algorithms=["HS512"]
            )
            print("token validate successfully!")
        except jwt.ExpiredSignatureError:
            print("Token has expired")
        except Exception as e:
            print(str(e))
