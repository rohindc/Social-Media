import {
  ChatBubbleOutlineOutlined,
  FavoriteBorderOutlined,
  FavoriteOutlined,
  ShareOutlined,
} from "@mui/icons-material";
import {
  Box,
  Divider,
  IconButton,
  TextField,
  Typography,
  useTheme,
} from "@mui/material";
import FlexBetween from "components/FlexBetween";
import Friend from "components/Friend";
import WidgetWrapper from "components/WidgetWrapper";
import { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { setPost } from "state";

const PostWidget = ({
  postId,
  postUserId,
  name,
  description,
  location,
  picturePath,
  userPicturePath,
  likes,
  comments,
}) => {
  const [isComments, setIsComments] = useState(false);
  const dispatch = useDispatch();
  const loggedInUserId = useSelector((state) => state.user._id);
  const isLiked = Boolean(
    Array.isArray(likes) && likes.includes(loggedInUserId)
  );
  const likeCount = Array.isArray(likes) && likes.length;
  const commentsCount = Array.isArray(comments) && comments.length;

  const { palette } = useTheme();
  const main = palette.neutral.main;
  const primary = palette.primary.main;

  const patchLike = async () => {
    const response = await fetch(`http://localhost:9093/posts/${postId}/like`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: loggedInUserId,
    });
    const updatedPost = await response.json();
    dispatch(setPost({ post: updatedPost }));
  };

  const addComment = async () => {
    const response = await fetch(``, {
      method: "PUT",
      body: loggedInUserId, 
    });
    const updatedPost = await response.json();
    dispatch(setPost({ post: updatedPost }));
  };

  return (
    <WidgetWrapper m="2rem 0">
      <Friend
        friendId={postUserId}
        name={name}
        subtitle={location}
        userPicturePath={userPicturePath}
      />
      <Typography color={main} sx={{ mt: "1rem" }}>
        {description}
      </Typography>
      {picturePath && (
        <img
          width="100%"
          height="auto"
          alt="post"
          style={{ borderRadius: "0.75rem", marginTop: "0.75rem" }}
          src={`http://localhost:9093/assets/${picturePath}`}
        />
      )}
      <FlexBetween mt="0.25rem">
        <FlexBetween gap="1rem">
          <FlexBetween gap="0.3rem">
            <IconButton onClick={patchLike}>
              {isLiked ? (
                <FavoriteOutlined sx={{ color: primary }} />
              ) : (
                <FavoriteBorderOutlined />
              )}
            </IconButton>
            <Typography>{likeCount}</Typography>
          </FlexBetween>

          <FlexBetween gap="0.3rem">
            <IconButton onClick={() => setIsComments(!isComments)}>
              <ChatBubbleOutlineOutlined />
            </IconButton>
            <Typography> {commentsCount} </Typography>
          </FlexBetween>
        </FlexBetween>

        <IconButton>
          <ShareOutlined />
        </IconButton>
      </FlexBetween>
      {isComments && (
        <Box mt="0.5rem">
          {/* {Array.isArray(comments) &&
          comments.map((comment, i) => ( */}
          <Box
            display="flex"
            alignItems="left"
            marginBottom="0.75rem"
            color="red"
          >
            {/* key={`${name}-${i}`}> */}
            <Divider />
            <img
              alt="img"
              src={`http://localhost:9093/assets/${picturePath}`}
              width="32px"
              height="32px"
              style={{ borderRadius: "50%", marginTop: "0.75rem" }}
            />
            <Typography sx={{ color: main, m: "0.5rem 0", pl: "1rem" }}>
              {/* {comment} */}
              abc da afaf a fa fa fa f fa fa a ga g gdgd gd gd g dg d j nn nd
              njd ndaad da f a fa f a f af a f f fs f s gs g vcwc svs v sv s vs
              d sf sfsf s fs fs fsf ffscsc sc scs cs
            </Typography>
          </Box>
          <TextField label="Comments" fullWidth onClick={addComment()}/>
          {/* ))} */}
          <Divider />
        </Box>
      )}
    </WidgetWrapper>
  );
};

export default PostWidget;
